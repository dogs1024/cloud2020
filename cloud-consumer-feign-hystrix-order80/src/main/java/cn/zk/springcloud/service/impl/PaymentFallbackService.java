package cn.zk.springcloud.service.impl;

import cn.zk.springcloud.service.IPaymentHystrixService;
import org.springframework.stereotype.Component;

/**
 * @author zk
 * @version 1.0
 * @description 当服务宕机时，消费客户端自身对每个功能做降级处理。
 * @date 2020/9/30 11:55
 */
@Component
public class PaymentFallbackService implements IPaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_OK ,o(╥﹏╥)o";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_TimeOut ,o(╥﹏╥)o";
    }
}
