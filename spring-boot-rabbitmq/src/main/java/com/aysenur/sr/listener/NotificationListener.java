package com.aysenur.sr.listener;

import com.aysenur.sr.model.Notification;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationListener {
    //kuyruktan surekli notificationları dinliycek alacak baska birsey yapacak

    @RabbitListener(queues = "aysenur-queue") //message'ı bu kuyruktan dinliyecek
    public void handleMessage(Notification notification){ //notificationı alıp process eder
        System.out.println("Message received..");
        System.out.println(notification.toString()); //aldıgı her msjı ekrana yazack

    }

}
