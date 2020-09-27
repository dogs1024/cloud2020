package cn.zk.springcloud.service;

import cn.zk.springcloud.entities.CommonResult;
import cn.zk.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author zk
 * @version 1.0
 * @description 服务消费者-openfeign客户端
 * @date 2020/9/27 14:33
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
    @GetMapping(value = "/payment/get/{id}")    //restuful风格。因为只做查询 没有对数据库进行操作。
    public CommonResult getPaymentById(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/creat")      //restuful风格。因为对数据库进行写操作。
    public CommonResult creat(@RequestBody Payment payment);

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout();
}
