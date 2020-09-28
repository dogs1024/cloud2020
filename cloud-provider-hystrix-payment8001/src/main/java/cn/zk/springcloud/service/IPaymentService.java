package cn.zk.springcloud.service;

/**
 * @author zk
 * @version 1.0
 * @description
 * @date 2020/9/28 16:28
 */
public interface IPaymentService {
    //成功读取
    String paymentInfo_OK(Integer id);

    //延时读取
    String paymentInfo_TimeOut(Integer id);
}
