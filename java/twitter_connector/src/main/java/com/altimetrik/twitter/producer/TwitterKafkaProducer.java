package com.altimetrik.twitter.producer;

import com.google.gson.Gson;
import com.twitter.hbc.ClientBuilder;
import com.twitter.hbc.core.Client;
import com.twitter.hbc.core.Constants;
import com.twitter.hbc.core.HttpHosts;
import com.twitter.hbc.core.endpoint.StatusesFilterEndpoint;
import com.twitter.hbc.core.processor.StringDelimitedProcessor;
import com.twitter.hbc.httpclient.auth.Authentication;
import com.twitter.hbc.httpclient.auth.OAuth1;
import com.altimetrik.twitter.config.KafkaConfiguration;
import com.altimetrik.twitter.config.TwitterConfiguration;
import com.altimetrik.twitter.model.Tweet;
import com.altimetrik.twitter.producer.callback.BasicCallback;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.LongSerializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


public class TwitterKafkaProducer {

    /**
     * Instance Variables:-
     * client
     * queue
     * gson
     * callback
     */
    private Client client;
    private BlockingQueue<String> queue;
    private Gson gson;
    private Callback callback;

    /**
     * Parameterized Constructor which accepts a list of iteams to be searched
     * @param hashtag
     */
    public TwitterKafkaProducer(List<String> hashtag) {
        // Configure auth
        Authentication authentication = new OAuth1(
                TwitterConfiguration.CONSUMER_KEY,
                TwitterConfiguration.CONSUMER_SECRET,
                TwitterConfiguration.ACCESS_TOKEN,
                TwitterConfiguration.TOKEN_SECRET);

        // track the terms of your choice. here im only tracking #bigdata.
        StatusesFilterEndpoint endpoint = new StatusesFilterEndpoint();
        endpoint.trackTerms(hashtag);

        queue = new LinkedBlockingQueue<>(10000);

        client = new ClientBuilder().name("Twitter_Client")
                .hosts(Constants.STREAM_HOST)
                .authentication(authentication)
                .endpoint(endpoint)
                .processor(new StringDelimitedProcessor(queue))
                .build();
        gson = new Gson();
        callback = new BasicCallback();
    }

    /**
     * Return the Kafka producer object which is responsible to push messages to Kafka Topic
     * @return
     */
    private Producer<Long, String> getProducer() {
        Properties properties = new Properties();
        System.out.println(KafkaConfiguration.SERVERS);
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConfiguration.SERVERS);
        properties.put(ProducerConfig.ACKS_CONFIG, "1");
        properties.put(ProducerConfig.LINGER_MS_CONFIG, 500);
        properties.put(ProducerConfig.RETRIES_CONFIG, 0);
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, LongSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        return new KafkaProducer<>(properties);
    }

    /**
     * Run method is responsible to iterate through the queue object, pull messages from queue and
     * Push messages to the Kafka.
     */
    public void run() {
        client.connect();
        try (Producer<Long, String> producer = getProducer()) {
            while (true) {
                Tweet tweet = gson.fromJson(queue.take(), Tweet.class);
                if (tweet.getLang().equals("en")) {
                    long key = tweet.getId();
                    String msg = tweet.toString();
                ProducerRecord<Long, String> record = new ProducerRecord<>(KafkaConfiguration.TOPIC, key, msg);
                producer.send(record, callback);
                System.out.println("Message sent Successfully " + key);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            client.stop();
        }
    }
}
