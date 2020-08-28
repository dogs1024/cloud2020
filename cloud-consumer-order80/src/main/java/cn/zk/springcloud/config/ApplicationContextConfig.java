package cn.zk.springcloud.config;

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
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
//等同于applicationContext.xml 中配置的 <bean id="" class="" ...>
