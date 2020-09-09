package cn.zk.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author zk
 * @version 1.0
 * @description 服务提供者
 * @date 2020/9/9 14:48
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/consul")
    public String paymentzk() {
        return "springcloud with consul port:" + serverPort + "\t" + UUID.randomUUID().toString();
    }

}
