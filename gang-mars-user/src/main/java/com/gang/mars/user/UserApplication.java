package com.gang.mars.user;

import com.gang.mars.common.service.OrderService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author gang.chen
 * @description 用户应用
 * @time 2021/3/1 13:02
 */
@SpringBootApplication
public class UserApplication {

    @DubboReference(version = "${rpc.service.version}", loadbalance = "roundrobin")
    private OrderService orderService;

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(UserApplication.class,args);

        OrderService bean = context.getBean(OrderService.class);

        for (int i = 0; i < 10; i++) {
            System.out.println(bean.loadBalanceTest());
        }
    }
}
