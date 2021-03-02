package com.gang.mars.user.resource;

import com.gang.mars.common.service.OrderService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gang.chen
 * @description
 * @time 2021/3/2 12:50
 */
@RestController
public class UserResource {
    @DubboReference(version = "${rpc.service.version}")
    OrderService orderService;

    @GetMapping("/user/getOrder")
    public String getOrder(){
        return "order data ->"+orderService.create();
    }
}
