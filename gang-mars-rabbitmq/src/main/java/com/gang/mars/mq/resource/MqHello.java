package com.gang.mars.mq.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gang.chen
 * @description
 * @time 2021/3/31 8:30
 */
@RestController
public class MqHello {

    @GetMapping("/hello")
    public String sayHello(){
        return "I say hei...";
    }
}
