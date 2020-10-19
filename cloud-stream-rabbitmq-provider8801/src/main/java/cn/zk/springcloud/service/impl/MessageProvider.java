package cn.zk.springcloud.service.impl;

import cn.hutool.core.lang.UUID;
import cn.zk.springcloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;

/**
 * @author zk
 * @version 1.0
 * @description 消息驱动之生产者
 * @date 2020/10/19 14:30
 */
@EnableBinding(Source.class)            // 定义消息的推送管道
public class MessageProvider implements IMessageProvider {
    @Resource
    private MessageChannel output;      // 消息发送管道

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("***********serial:"+serial);
        return serial;
    }
}
