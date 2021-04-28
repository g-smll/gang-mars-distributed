package com.gang.mars.netty.netty.client;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * @author gang.chen
 * @description
 * @time 2021/4/16 9:09
 */
public class NettyClientHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        ByteBuf byteBuf = Unpooled.copiedBuffer("客户端输出：Hello server".getBytes(CharsetUtil.UTF_8));
        /**
         * (1)问关于上下文写消息,如下方式是否能成功
         * ctx.writeAndFlush(ByteBuf) -> ctx.writeAndFlush("")
         * 答复：不能；原因是：客户端机器A，服务端机器B，真实的场景是从A机器->线路->B机器，数据传输只能是二进制数据而非字符
         * */
        ctx.writeAndFlush(byteBuf);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ByteBuf byteBuf = (ByteBuf) msg;
        System.out.println("客户端输出："+byteBuf.toString(CharsetUtil.UTF_8));
        System.out.println("客户端输出："+ctx.channel().remoteAddress());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }
}
