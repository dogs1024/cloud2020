package cn.zk.springcloud.controller;

import cn.zk.springcloud.entities.CommonResult;
import cn.zk.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
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
//    public static final String PAYMENT_URL="http://localhost:8001";       //单机版。写死
    public static final String PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE";         //集群版。写服务名称。

    @Resource           //将RestTemplate注入进来
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/creat")
    public CommonResult<Payment> creat(Payment payment){
        return  restTemplate.postForObject(PAYMENT_URL+"/payment/creat",payment,CommonResult.class);
    }

    /**
     * 返回对象为响应体中数据转化成的对象。JSON串
     * @param id
     * @return CommonResult
     */
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        return  restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }

    /**
     * 返回对象为ResponseEntity对象，包含了响应中的一些重要信息，如响应头、响应状态码、响应体...
     * @param id
     * @return CommonResult
     */
    @GetMapping("/consumer/payment/getEntity/{id}")
    public CommonResult<Payment> getPayment2(@PathVariable("id") Long id){
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody();
        }else {
            return new CommonResult<>(444,"操作失败！");
        }
    }

    @GetMapping("/consumer/payment/entity/creat")
    public CommonResult<Payment> creat2(Payment payment){
        return  restTemplate.postForEntity(PAYMENT_URL+"/payment/creat",payment,CommonResult.class).getBody();
    }
}
