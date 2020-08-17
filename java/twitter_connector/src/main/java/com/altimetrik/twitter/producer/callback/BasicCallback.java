package com.altimetrik.twitter.producer.callback;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.RecordMetadata;

/**
 * Callback operation
 */
public class BasicCallback implements Callback {
    /**
     * Overridden version of onCompletion method for BasicCallback class.
     * @param metadata
     * @param exception
     */
    @Override
    public void onCompletion(RecordMetadata metadata, Exception exception) {
        if (exception == null) {
            System.out.printf("Message with offset %d acknowledged by partition %d\n",
                    metadata.offset(), metadata.partition());
        } else {
            System.out.println(exception.getMessage());
        }
    }
}
