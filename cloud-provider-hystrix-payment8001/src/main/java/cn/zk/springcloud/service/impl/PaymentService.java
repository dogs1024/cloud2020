package cn.zk.springcloud.service.impl;

import cn.zk.springcloud.service.IPaymentService;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author zk
 * @version 1.0
 * @description 查看Tomcat线程池的调用
 * @date 2020/9/28 16:30
 */
@Service
public class PaymentService implements IPaymentService {

    //成功
    @Override
    public String paymentInfo_OK(Integer id) {
        return "线程池："+Thread.currentThread().getName()+"   paymentInfo_OK,id：  "+id+"\t"+"我是正常访问" ;
    }

    //模拟失败，测试Hystrix断路器
    @Override
    public String paymentInfo_TimeOut(Integer id) {
        int timeNum = 3;
        try {
            TimeUnit.SECONDS.sleep(timeNum);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "线程池："+Thread.currentThread().getName()+"   paymentInfo_TimeOut,id：  "+id+"\t"+"我是延时访问   耗时（s）："+timeNum ;
    }
}
