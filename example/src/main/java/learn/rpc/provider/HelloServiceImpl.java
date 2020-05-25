package learn.rpc.provider;

import learn.rpc.publicinterface.HelloService;

/**
 * @program: netty-parent
 * @description:
 * @author: Zhu Zheng-yi
 * @create: 2020-05-25 18:30
 **/

public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String msg) {
        System.out.println("收到客户端消息=" + msg);

        // 根据msg,返回不同的结果
        if (msg != null) {
            return "你好客户端，我已经收到你的消息 [ " + msg + " ]";
        } else {
            return "你好客户端，我已经收到你的消息";
        }
    }
}
