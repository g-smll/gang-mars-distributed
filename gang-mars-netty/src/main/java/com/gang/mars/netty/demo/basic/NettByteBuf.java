package com.gang.mars.netty.demo.basic;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.CharsetUtil;


import java.sql.SQLOutput;

/**
 * @author gang.chen
 * @description
 * @time 2021/4/26 12:55
 */
public class NettByteBuf {

    public static void main(String[] args) {

        /*
         * 输出byteBuf，初始化空间后
         * ridx - > 0
         * widx - > 0
         * cap - > 10
         * */
        ByteBuf byteBuf = Unpooled.buffer(10);
        System.out.println("0-> byteBuf= " + byteBuf);


        /*
         * writeBye 写数据到空间，0->7 一共写了8个元素
         * ridx - > 0
         * widx - > 8
         * cap - > 10
         * */
        for (int i=0;i<8;i++){
            byteBuf.writeByte(i);
        }
        System.out.println("1-> byteBuf= " + byteBuf);

        /*
         * getByte 取数据， 0 - > 4, 共5个元素
         * ridx - > 0
         * widx - > 8
         * cap - > 10
         * */
        for (int i =0; i<5; i++) {
            System.out.println("2->"+byteBuf.getByte(i));
        }
        System.out.println("3-> byteBuf = " + byteBuf);

        /*
         * readByte,读数据，0 - > 4, 共4个元素
         * ridx - > 5
         * widx - > 5
         * cap - 10
         * */
        for (int i = 0; i < 5; i++) {
            System.out.println("4->"+byteBuf.readByte());
        }
        System.out.println("5->byteBuf = " + byteBuf);


        ByteBuf byteBuf_1 = Unpooled.copiedBuffer("hell, gang.chen", CharsetUtil.UTF_8);
        if (byteBuf_1.hasArray()) {
            byte[] array = byteBuf_1.array();

            System.out.println("X1 -> "+ new String(array,CharsetUtil.UTF_8));

            System.out.println("X2 byteBuf_1 - > " + byteBuf_1);

            System.out.println("X3 -> " + byteBuf_1.getByte(0));

            int len = byteBuf_1.readableBytes();
            System.out.println("X4 -> " + byteBuf_1.readableBytes());

            for (int i = 0; i < len; i++) {
                System.out.println("X5 ->" + (char)byteBuf_1.getByte(i));
            }

            System.out.println("X6 -> " +byteBuf_1.getCharSequence(0,6,CharsetUtil.UTF_8));
            System.out.println("X7 ->" + byteBuf_1.getCharSequence(6,6,CharsetUtil.UTF_8));
        }

    }
}
