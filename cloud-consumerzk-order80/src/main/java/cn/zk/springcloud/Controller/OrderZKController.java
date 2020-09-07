package cn.zk.springcloud.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author zk
 * @version 1.0
 * @description
 * @date 2020/9/7 10:38
 */
@RestController
@Slf4j
public class OrderZKController {

    public static final String INVOKE_URL="http://cloud-provider-payment";

    @Resource
    public RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/zk")
    public String payment(){
        String result = restTemplate.getForObject(INVOKE_URL + "/payment/zk", String.class);
        return result;
    }

}
