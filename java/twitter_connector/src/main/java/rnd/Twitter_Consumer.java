package rnd;

import com.twitter.hbc.ClientBuilder;
import com.twitter.hbc.core.Client;
import com.twitter.hbc.core.Constants;
import com.twitter.hbc.core.Hosts;
import com.twitter.hbc.core.HttpHosts;
import com.twitter.hbc.core.endpoint.StatusesFilterEndpoint;
import com.twitter.hbc.core.processor.StringDelimitedProcessor;
import com.twitter.hbc.httpclient.auth.Authentication;
import com.twitter.hbc.httpclient.auth.OAuth1;
import org.apache.kafka.common.protocol.types.Field;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Twitter_Consumer {
    private Client getTwitterClient(BlockingQueue<String> messageQueue) {

        String clientName = "Twitter_Client";
        String consumerKey = "WnACC44R71UN7HnmhWCpyrDLf";
        String consumerSecret = "SUuCdmSEM2nLx4bsGAWDXWGHnT7bSYbZnD0DTPnFGkW9dNm4XF";
        String token = "1149560340817907713-NZV0S5scNyghrTEgdobXMRR3LMOhix";
        String tokenSecret = "rzDLRCbRORNap1YuuVKvg2UqbMvm1P6jSO5W5DBQ0tvwQ";
        List<String> searchTerms = Arrays.asList("india".split(","));

        Authentication authentication = new OAuth1(consumerKey,consumerSecret,token,tokenSecret);
        Hosts hosebirdHosts = new HttpHosts(Constants.STREAM_HOST);
        StatusesFilterEndpoint hosebirdEndpoint = new StatusesFilterEndpoint();

        hosebirdEndpoint.trackTerms(searchTerms);

        ClientBuilder clientBuilder = new ClientBuilder();
        clientBuilder.name(clientName)
                .hosts(hosebirdHosts)
                .authentication(authentication)
                .endpoint(hosebirdEndpoint)
                .processor(new StringDelimitedProcessor(messageQueue));

        return clientBuilder.build();

    }

    public static void main(String[] args) throws Exception {
        Twitter_Consumer x = new Twitter_Consumer();
        LinkedBlockingQueue<String> queue  = new LinkedBlockingQueue<>(100000);
        Client client = x.getTwitterClient(queue);
        client.connect();
        System.out.println("Client created successfully");
        System.out.println(queue.take().toString());
        System.out.println("Data Received");
    }
}
