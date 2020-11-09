package cn.zk.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zk
 * @version 1.0
 * @description Sentine服务熔断
 * @date 2020/11/9 18:01
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AppMain8401 {
    public static void main(String[] args) {
        SpringApplication.run(AppMain8401.class,args);
    }
}
