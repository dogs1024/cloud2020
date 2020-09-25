package cn.zk.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author zk
 * @version 1.0
 * @description 手写轮询负载均衡算法。
 * @date 2020/9/25 16:54
 */
public interface LoadBalancer {
    //收集服务器中有多少台提供服务的机器，并放到List里面
    ServiceInstance instances(List<ServiceInstance> instances);
}
