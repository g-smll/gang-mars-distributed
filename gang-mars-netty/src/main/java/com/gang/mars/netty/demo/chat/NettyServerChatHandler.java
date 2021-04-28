package com.gang.mars.netty.demo.chat;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author gang.chen
 * @description
 * @time 2021/4/21 8:51
 */
public class NettyServerChatHandler extends SimpleChannelInboundHandler<String> {

    private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    //###################################
    //## 重点 与服务端链接完成时 该方法被激活
    //##################################
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channelGroup.writeAndFlush("[客户端]"+channel.remoteAddress()+" 上线" +format.format(new Date())+"\n");
        channelGroup.add(channel);
        System.out.println(ctx.channel().remoteAddress() + " 上线了 " + "\n");
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) {

    }
}
