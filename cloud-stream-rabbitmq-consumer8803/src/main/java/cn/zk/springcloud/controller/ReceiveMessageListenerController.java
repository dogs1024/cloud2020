package cn.zk.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;


/**
 * @author zk
 * @version 1.0
 * @description 消息驱动之消费者
 * @date 2020/10/19 17:37
 */
@Component
@EnableBinding(Sink.class)          //定义消息接收管道
public class ReceiveMessageListenerController {
    @Value("${server.port}")
    private String port;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message) {
        System.out.println("消费者2号，接收："+message.getPayload()+"\t port:"+port);
    }
}
