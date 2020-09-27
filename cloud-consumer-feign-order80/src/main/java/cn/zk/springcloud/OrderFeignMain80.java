package cn.zk.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author zk
 * @version 1.0
 * @description openfeign服务调用
 * @date 2020/9/27 14:02
 */
@SpringBootApplication
@EnableFeignClients             //使用@FeignClien,需要在主启动类上添加相应的注解激活并开启
public class OrderFeignMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignMain80.class,args);
    }
}
