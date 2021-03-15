package com.gang.mars.order.service.impl;

import com.gang.mars.common.dto.OrderDTO;
import com.gang.mars.common.service.OrderService;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.rpc.RpcContext;

/**
 * @author gang.chen
 * @description 订单service类的实现
 * @time 2021/3/2 8:16
 */
@DubboService(version = "${rpc.service.version}",loadbalance = "roundrobin")
public class OrderServiceImpl implements OrderService {
    @Override
    public OrderDTO create() {
        URL url = RpcContext.getContext().getUrl();
        String.format("%s:%s,create(),%s",url.getProtocol(),url.getPort(),"创建订单");
        return new OrderDTO(1,"陈纲");
    }

    @Override
    public String loadBalanceTest() {
        URL url = RpcContext.getContext().getUrl();
        String result = String.format("%s:%s,create(),%s",url.getProtocol(),url.getPort(),"创建订单");
        return result;
    }
}
