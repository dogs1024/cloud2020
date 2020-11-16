package cn.zk.springcloud.controller;

import cn.hutool.core.util.IdUtil;
import cn.zk.springcloud.entities.CommonResult;
import cn.zk.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author zk
 * @version 1.0
 * @description
 * @date 2020/11/10 18:01
 */
@RestController
public class PaymentController
{
    @Value("${server.port}")
    private String serverPort;

    public static HashMap<Long, Payment> hashMap = new HashMap<>();
    static{
        for (Long id = 1L; id <= 10 ; id ++) {
            hashMap.put(id,new Payment(id, IdUtil.simpleUUID()));
        }
    }

    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id){
        Payment payment = hashMap.get(id);
        CommonResult<Payment> result = new CommonResult(200,"from mysql,serverPort:  "+serverPort,payment);
        return result;
    }
}
