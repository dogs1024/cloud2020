package cn.zk.springcloud.controller;

import cn.zk.springcloud.service.IPaymentService;
import cn.zk.springcloud.service.impl.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zk
 * @version 1.0
 * @description Hystrix熔断器：服务降级、服务熔断、服务限流
 * @date 2020/9/28 16:42
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private IPaymentService iPaymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        String result = iPaymentService.paymentInfo_OK(id);
        log.info("**********result:"+result);
        return result;
    }

    @GetMapping(value = "/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id){
        String result = iPaymentService.paymentInfo_TimeOut(id);
        log.info("**********result:"+result);
        return result;
    }

    //===服务熔断
    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        String result = iPaymentService.paymentCircuitBreaker(id);
        log.info("*******result:"+result);
        return result;
    }
}
