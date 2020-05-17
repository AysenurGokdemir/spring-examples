package com.aysenur.sr.producer;
import java.util.Date;
import java.util.UUID;
import javax.annotation.PostConstruct;

import com.aysenur.sr.model.Notification;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class NotificationProducer {

    @Value("${sr.rabbit.routing.name}")
    private String routingName;

    @Value("${sr.rabbit.exchange.name}")
    private String exchangeName;


    @PostConstruct
    public void init() {
        Notification notification = new Notification();
        notification.setNotificationId(UUID.randomUUID().toString());
        notification.setCreatedAt(new Date());
        notification.setMessage("WELCOME TO RABBITMQ");
        notification.setSeen(Boolean.FALSE);

        try {
            Thread t=new Thread();
            t.start();
            sendToQueue(notification);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendToQueue(Notification notification) throws InterruptedException  {
        System.out.println("Notification Sent ID : " + notification.getNotificationId());
        rabbitTemplate.convertAndSend(exchangeName, routingName, notification);
        Thread.sleep(5000);
    }

}
