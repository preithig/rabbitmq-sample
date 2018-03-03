package com.sample.amqp;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by PRGA on 3/2/2018.
 */
public class Publisher {

    public static final String QUEUE_NAME = "testqueue";

    public static void main(String args[]) throws IOException, TimeoutException {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false,false,false,null);
        String message = "Test Message";

        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());

        channel.close();
        connection.close();

    }
}
