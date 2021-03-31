package com.gang.mars.order.service.impl;

import com.gang.mars.common.service.TimeoutService;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.rpc.RpcContext;

import java.util.concurrent.TimeUnit;

/**
 * @author gang.chen
 * @description 方法超时配置
 * @time 2021/3/16 12:58
 */
@DubboService(version = "timeout",timeout = 6000) //超时时间为6秒
public class TimeoutServiceImpl implements TimeoutService {
    @Override
    public String timeout() {
        System.out.println("方法 -> timeout() 开始...");
        try {
            TimeUnit.SECONDS.sleep(5);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("方法 -> timeout() 结束...");
        URL url = RpcContext.getContext().getUrl();
        return String.format("%s: %s, timeout, %s",url.getProtocol(),url.getPort(),"timeout");
    }
}
