package com.altimetrik.twitter;

import com.altimetrik.twitter.producer.TwitterKafkaProducer;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static String propertyFile;
    public static void main(String[] args){
        if (args.length < 1) {
            System.out.println("Please provide atlease one HASHTAG");
            System.exit(-1);
        }
        propertyFile = args[0];

        List<String> hashtags = new ArrayList<String>();
        for(int i = 1; i < args.length; i++){
            hashtags.add(args[i]);
        }

        TwitterKafkaProducer tFK = new TwitterKafkaProducer(hashtags);
        tFK.run();
    }
}
