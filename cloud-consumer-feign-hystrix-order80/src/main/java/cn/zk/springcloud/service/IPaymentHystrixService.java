package cn.zk.springcloud.service;

import cn.zk.springcloud.service.impl.PaymentFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zk
 * @version 1.0
 * @description 方案二：客户端对每个服务方法做降级处理。
 *                      防止因服务端宕机而导致客户端挂起耗死服务器资源。
 * @date 2020/9/30 11:07
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = PaymentFallbackService.class)      //假如CLOUD-PROVIDER-HYSTRIX-PAYMENT服务挂了，就去找PaymentFallbackService.class来处理。
public interface IPaymentHystrixService {
    //成功读取
    @GetMapping(value = "/payment/hystrix/ok/{id}")
    String paymentInfo_OK(@PathVariable("id") Integer id);

    //延时读取
    @GetMapping(value = "/payment/hystrix/timeout/{id}")
    String paymentInfo_TimeOut(@PathVariable("id") Integer id);
}
