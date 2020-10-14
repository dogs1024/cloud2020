package cn.zk.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zk
 * @version 1.0
 * @description 网关路由映射配置
 * @date 2020/10/14 14:09
 */
@Configuration
public class GateWayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_rote_test",r -> r.path("/api/orderpass_zkV1.html").uri("http://api.lxt6.cn:8080/api/orderpass_zkV1.html")).build();
        return routes.build();
    }
}
