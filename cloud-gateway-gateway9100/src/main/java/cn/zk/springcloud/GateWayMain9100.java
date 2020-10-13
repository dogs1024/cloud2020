package cn.zk.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author zk
 * @version 1.0
 * @description GateWay网关。Route（路由）、Predicate（断言）、Filter（过滤）
 * @date 2020/10/13 17:29
 */
@SpringBootApplication
@EnableEurekaClient
public class GateWayMain9100 {
    public static void main(String[] args) {
        SpringApplication.run(GateWayMain9100.class,args);
    }
}
/*
* 网关优点：
*   1、对请求进行路由规则转发到服务器。
*   2、对请求进行过滤。
*   3、挡在最外层。对外暴露网关，防止服务器遭到恶意攻击。
*
* */