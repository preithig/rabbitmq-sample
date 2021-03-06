package com.sample.spring.amqp;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by PRGA on 3/3/2018.
 */
public class SpringSender {

    public static void main(String[] args)
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(RabbitMQConfig.class);
        AmqpTemplate template = context.getBean(AmqpTemplate.class);
        template.convertAndSend("This is a test msg");
        System.out.println("Sent message");
    }
}
