package cn.zk.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zk
 * @version 1.0
 * @description Ribbon的核心组件IRule。自定义负载均衡规则。（官方Ribbon的默认负载均衡机制是轮询。如果使用自定义负载均衡，
 *              则不能跟@ComponentScan在同包或子包下。也就是不能跟主启动类在同一个包。@SpringBootApplication注解中带有@ComponentScan）
 * @date 2020/9/10 10:53
 */
@Configuration
public class MySelfRule {
    @Bean
    public IRule myRule(){
        //负载均衡-随机机制
        return new RandomRule();
    }
}
