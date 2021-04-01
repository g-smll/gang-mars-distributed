package com.gang.mars.mq.service.direct;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author gang.chen
 * @description
 * @time 2021/4/1 13:40
 */
@Service
@RabbitListener(queues = {"wechat.direct.queue"})
public class ShortMessageConsumerService {

    @RabbitHandler
    public void receivedWeChatMessage(String message){
        System.out.println("WaChat message data->" + message);
    }
}
