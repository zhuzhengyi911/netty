package learn.rpc.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import learn.rpc.provider.HelloServiceImpl;
import learn.rpc.publicinterface.HelloService;

/**
 * @program: netty-parent
 * @description:
 * @author: Zhu Zheng-yi
 * @create: 2020-05-25 18:43
 **/

public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        // 获取客户端发送的消息，并调用服务
        System.out.println("msg=" + msg);
        // 客户端在调用服务器的API时，要遵守一个协议
        // 比如，每次发消息时都必须以某个字符串开头 "HelloServer#hello#你好"
        if (msg.toString().startsWith("HelloServer#hello")) {
            String result = new HelloServiceImpl().hello(msg.toString().substring(msg.toString().lastIndexOf('#') + 1));
            ctx.writeAndFlush(msg);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        // 关闭通道
        ctx.close();
    }
}
