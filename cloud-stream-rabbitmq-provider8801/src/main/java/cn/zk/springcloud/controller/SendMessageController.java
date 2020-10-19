package cn.zk.springcloud.controller;

import cn.zk.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zk
 * @version 1.0
 * @description MQ生产者
 * @date 2020/10/19 14:23
 */
@RestController
public class SendMessageController {
    @Resource
    IMessageProvider iMessageProvider;

    @GetMapping("/sendMessage")
    public String sendMessage(){
        return iMessageProvider.send();
    }
}
