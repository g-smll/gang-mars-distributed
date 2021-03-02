package com.gang.mars.order.service.impl;

import com.gang.mars.common.dto.OrderDTO;
import com.gang.mars.common.service.OrderService;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author gang.chen
 * @description 订单service类的实现
 * @time 2021/3/2 8:16
 */
@DubboService(version = "${rpc.service.version}")
public class OrderServiceImpl implements OrderService {
    @Override
    public OrderDTO create() {
        return new OrderDTO(1,"陈纲");
    }
}
