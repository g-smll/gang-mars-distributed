package com.gang.mars.mq.service.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author gang.chen
 * @description 邮件消息消费
 * @time 2021/3/31 13:29
 */
@Service
@RabbitListener(queues = {"email.fanout.queue"})
public class EmailMqConsumerService {

    @RabbitHandler
    public void receiveEmailMessage(String message){
        System.out.println("email message data->" + message);
    }
}
