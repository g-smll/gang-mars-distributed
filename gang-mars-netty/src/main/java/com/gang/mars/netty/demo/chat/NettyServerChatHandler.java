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

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

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

    //###################################
    //## 重点 处于不活动状态， 激活该方法
    //##################################
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channelGroup.writeAndFlush("[ 客户端 ]" + channel.remoteAddress() + "下线了" +"\n");
        System.out.println(ctx.channel().remoteAddress() +" 下线了 " +"\n");
        System.out.println("channelGroup size =" + channelGroup.size());
    }

    //###################################
    //## 重点 读取客户端数据
    //##################################
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) {
        Channel channel = ctx.channel();
        channelGroup.forEach(ch ->{
            if (channel != ch) {
                ch.writeAndFlush("[ 客户端 ]" + channel.remoteAddress() +" 发送消息：" +msg + "\n");
            }else {
                ch.writeAndFlush("[ 自己 ]发送了消息： "+msg+" \n");
            }
        });
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
        ctx.close();
    }
}
