package cn.zk.springcloud.controller;

import cn.zk.springcloud.entities.CommonResult;
import cn.zk.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author zk
 * @version 1.0
 * @description 客户端调取支付模块
 * @date 2020/8/28 11:35
 */
@RestController
@Slf4j
public class OrderController {
    //服务调用地址
    public static final String PAYMENT_URL="http://localhost:8001";

    @Resource           //将RestTemplate注入进来
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/creat")
    public CommonResult<Payment> creat(Payment payment){
        return  restTemplate.postForObject(PAYMENT_URL+"/payment/creat",payment,CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        return  restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }
}
