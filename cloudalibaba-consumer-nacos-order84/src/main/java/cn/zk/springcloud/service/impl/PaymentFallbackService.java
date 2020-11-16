package cn.zk.springcloud.service.impl;

import cn.zk.springcloud.entities.CommonResult;
import cn.zk.springcloud.entities.Payment;
import cn.zk.springcloud.service.PaymentService;
import org.springframework.stereotype.Component;

/**
 * @author zk
 * @version 1.0
 * @description
 * @date 2020/11/16 15:49
 */
@Component
public class PaymentFallbackService implements PaymentService
{
    @Override
    public CommonResult<Payment> paymentSQL(Long id)
    {
        return new CommonResult<>(44444,"服务降级返回,---PaymentFallbackService",new Payment(id,"errorSerial"));
    }
}

