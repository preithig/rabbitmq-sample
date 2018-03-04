package com.sample.spring.amqp;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by PRGA on 3/3/2018.
 */
public class SpringReceiver {


    public static void main (String[] args){
        ApplicationContext context  = new AnnotationConfigApplicationContext(RabbitMQConfig.class);
        AmqpTemplate template = context.getBean(AmqpTemplate.class);

        System.out.print("Message received " + template.receiveAndConvert());
       }
}
