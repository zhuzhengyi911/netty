package learn.rpc.provider;

import learn.rpc.netty.NettyServer;

/**
 * @program: netty-parent
 * @description: 启动服务提供者
 * @author: Zhu Zheng-yi
 * @create: 2020-05-25 18:33
 **/

public class ServerBootstrap {

    public static void main(String[] args) {
        // to do
        NettyServer.startServer("127.0.0.1", 7000);
    }

}
