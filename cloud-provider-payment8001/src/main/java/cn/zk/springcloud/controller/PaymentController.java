package cn.zk.springcloud.controller;

import cn.zk.springcloud.entities.CommonResult;
import cn.zk.springcloud.entities.Payment;
import cn.zk.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author zk
 * @version 1.0
 * @description
 * @date 2020/8/27 14:34
 */
//@Controller           //controller层注解。
@RestController         //controller层注解。简单的返回视图。
@Slf4j
public class PaymentController {

    @Resource
    PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;        //服务发现。将服务暴露给使用者。

    //@RequestMapping                           //地址映射
    @PostMapping(value = "/payment/creat")      //restuful风格。因为对数据库进行写操作。
    public CommonResult creat(@RequestBody Payment payment) {        //@RequestBody 接收前端传递给后端的数据
        int creat = paymentService.creat(payment);
        log.info("插入状态：" + creat);
        if (creat > 0) {
            return new CommonResult(200, "插入数据库成功。serverPort：" + serverPort, creat);
        } else {
            return new CommonResult(500, "插入数据库失败", null);
        }
    }

    //读操作
    @GetMapping(value = "/payment/get/{id}")    //restuful风格。因为只做查询 没有对数据库进行操作。
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询结果：" + payment);
        if (payment != null) {
            return new CommonResult(200, "查询成功。serverPort：" + serverPort, payment);
        } else {
            return new CommonResult(500, "没有对应的记录，查询ID：" + id, null);
        }
    }

    //服务发现
    @GetMapping(value = "/payment/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            log.info("********element" + element);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
        return this.discoveryClient;
    }

    //测试手写轮询负载均衡算法
    @GetMapping(value = "/payment/lb")
    public String getPaymentLB() {
        return serverPort;
    }

    //测试OpenFeign服务提供端超时。
    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return serverPort;
    }

    // 链路监控
    @GetMapping("/payment/zipkin")
    public String paymentZipkin()
    {
        return "hi ,i'am paymentzipkin server fall back，welcome to atguigu，O(∩_∩)O哈哈~";
    }
}
