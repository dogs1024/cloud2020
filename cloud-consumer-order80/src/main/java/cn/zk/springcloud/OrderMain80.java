package cn.zk.springcloud;

import cn.zk.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author zk
 * @version 1.0
 * @description 服务消费者
 * @date 2020/8/28 11:33
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MySelfRule.class)      //告诉主启动类使用自定义的负载均衡机制。服务名为CLOUD-PAYMENT-SERVICE的使用MySelfRule负载均衡机制
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class,args);
    }
}
