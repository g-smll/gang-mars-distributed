package com.gang.mars.mq.service.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author gang.chen
 * @description SMS消息消费
 * @time 2021/3/31 13:29
 */
@Service
@RabbitListener(queues = {"sms.fanout.queue"})
public class SmsMqConsumerService {

    @RabbitHandler
    public void receivedSmsMessage(String message){
        System.out.println("Sms message data ->"+ message);
    }
}
