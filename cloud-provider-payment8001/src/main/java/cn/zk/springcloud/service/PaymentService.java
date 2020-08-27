package cn.zk.springcloud.service;

import cn.zk.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author zk
 * @version 1.0
 * @description
 * @date 2020/8/27 14:12
 */
public interface PaymentService {
    //写操作
    public int creat(Payment payment);

    //读操作
    public Payment getPaymentById(@Param("id") Long id);
}
