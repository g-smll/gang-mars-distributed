package com.gang.mars.netty.demo.chat;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author gang.chen
 * @description 聊天室服务端
 * @time 2021/4/21 8:49
 */
public class NettyServerChat {
    public static void main(String[] args) throws InterruptedException{

        NioEventLoopGroup bassNioEventLoopGroup = new NioEventLoopGroup(1);
        NioEventLoopGroup workerNioEventLoopGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bassNioEventLoopGroup,workerNioEventLoopGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG,1024)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast(new NettyServerChatHandler());
                        }
                    });
            System.out.println("聊天室server启动...");

            ChannelFuture channelFuture = serverBootstrap.bind(9000).sync();

            channelFuture.channel().closeFuture().sync();
        }
        finally {
            bassNioEventLoopGroup.shutdownGracefully();
            workerNioEventLoopGroup.shutdownGracefully();
        }

    }
}
