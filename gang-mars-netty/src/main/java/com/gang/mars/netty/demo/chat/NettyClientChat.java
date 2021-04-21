package com.gang.mars.netty.demo.chat;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.Scanner;

/**
 * @author gang.chen
 * @description
 * @time 2021/4/21 8:50
 */
public class NettyClientChat  {

    public static void main(String[] args) throws InterruptedException{

        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();

        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventLoopGroup)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch){

                            ChannelPipeline pipeline = ch.pipeline();

                            pipeline.addLast(new NettyClientChatHandler());
                        }
                    });
            ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 9000).sync();

            Channel channel = channelFuture.channel();

            Scanner scanner = new Scanner(System.in);

            while (scanner.hasNextLine()){
                String s = scanner.nextLine();
                channel.writeAndFlush(s);
            }

        }
        finally {
            eventLoopGroup.shutdownGracefully();
        }

    }
}
