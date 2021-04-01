package com.gang.mars.mq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author gang.chen
 * @description MQ Direct 模式配置
 * @time 2021/4/1 13:21
 */
@Configuration
public class MqDirectConfiguration {

    @Bean
    public DirectExchange DirectExchange(){
        return new DirectExchange("direct_order_exchange",true,false);
    }

    @Bean
    public Queue WeChatQueue(){
        return new Queue("wechat.direct.queue",true);
    }

    @Bean
    public Binding WeChatBinding(){
        return BindingBuilder.bind(WeChatQueue()).to(DirectExchange()).with("wechat");
    }
}
