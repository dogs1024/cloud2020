package cn.zk.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author  zk
 * @date  2020年8月26日16:10:22
 * @version 1.0
 */
@SpringBootApplication
@EnableEurekaClient         //声明自己为Eureka客户端
public class PaymentMain8002 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8002.class,args);
    }
}

