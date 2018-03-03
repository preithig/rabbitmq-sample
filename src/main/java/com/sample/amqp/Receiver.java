package com.sample.amqp;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by PRGA on 3/2/2018.
 */
public class Receiver {

    public static void main(String args[]) throws IOException, TimeoutException {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(Publisher.QUEUE_NAME, false, false, false, null);

        Consumer consumer = new DefaultConsumer(channel){
            @Override
            public  void handleDelivery(String consumerTag,
                                        Envelope envelope,
                                        AMQP.BasicProperties properties,
                                        byte[] body){
                System.out.println("Message received: "+ new String(body));

            }

        };

        channel.basicConsume(Publisher.QUEUE_NAME, true, consumer);
    }
}
