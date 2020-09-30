package cn.zk.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author zk
 * @version 1.0
 * @description 消费端/客户端服务降级
 * @date 2020/9/30 10:51
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix          //激活并开启客户端Hystrix服务降级
public class OrderHystrixMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderHystrixMain80.class,args);
    }
}
