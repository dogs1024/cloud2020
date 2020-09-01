package cn.zk.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zk
 * @version 1.0
 * @description 服务提供者（注册进zookeeper服务注册中心）
 * @date 2020/9/1 17:22
 */
@SpringBootApplication
@EnableDiscoveryClient      //该注解用于向使用consul或者zookeeper作为注册服务中心时注册服务。
public class PaymentMain8004 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8004.class,args);
    }
}
