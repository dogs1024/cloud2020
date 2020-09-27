package cn.zk.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author zk
 * @version 1.0
 * @description Eureka提供服务端
 * @date 2020/8/28 16:31
 */
@SpringBootApplication
@EnableEurekaServer         //表示自己是EurekaServer端
public class EurekaMain7001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7001.class,args);
    }
}
