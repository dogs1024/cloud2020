package cn.zk.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author zk
 * @version 1.0
 * @description config配置类。springboot是容器，将RestTemplate注入到spring容器。
 * @date 2020/8/28 11:56
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    @LoadBalanced       //赋予RestTemplate负载均衡的能力。默认轮循负载均衡机制
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
//等同于applicationContext.xml 中配置的 <bean id="" class="" ...>
