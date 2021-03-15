package com.gang.mars.common.service;

import com.gang.mars.common.dto.OrderDTO;

/**
 * @author gang.chen
 * @description 订单service接口
 * @time 2021/3/2 8:09
 */
public interface OrderService {

    //创建订单
    OrderDTO create();

    //负载均衡测试
    String loadBalanceTest();
}
