package cn.zk.springcloud.dao;

import cn.zk.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author zk
 * @version 1.0
 * @description 订单
 * @date 2020/8/27 11:46
 */
@Mapper
public interface PaymentDao {
    //写操作
    public int creat(Payment payment);

    //读操作
    public Payment getPaymentById(@Param("id") Long id);
}
