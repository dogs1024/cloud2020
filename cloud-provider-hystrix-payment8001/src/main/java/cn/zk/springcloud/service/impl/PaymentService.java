package cn.zk.springcloud.service.impl;

import cn.zk.springcloud.service.IPaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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
        return "线程池："+Thread.currentThread().getName()+"   paymentInfo_OK,id：  "+id+"\t"+"我是正常访问    O(∩_∩)O" ;
    }

    //注：一般服务降级放在客户端
    //服务降级.模拟失败，测试Hystrix断路器
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            //约定当前线程超过3s阀值时调用paymentInfo_TimeOutHandler备用方法
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    @Override
    public String paymentInfo_TimeOut(Integer id) {
        //模拟超时
        int timeNum = 5;
        try {
            TimeUnit.SECONDS.sleep(timeNum);            //秒
//            TimeUnit.MILLISECONDS.sleep(timeNum);     //毫秒
        } catch (Exception e) {
            e.printStackTrace();
        }
        //模拟报错
//        int a = 10/0;
        return "线程池："+Thread.currentThread().getName()+"   paymentInfo_TimeOut,id：  "+id+"\t"+"我是延时访问   耗时（s）ヽ(#`Д´)ﾉ┌┛〃："+timeNum ;
    }

    //服务降级->备用方法->超时/报错后使用兜底的方法来替代原方法
    public String paymentInfo_TimeOutHandler(Integer id){
        return "线程池："+Thread.currentThread().getName()+"   paymentInfo_TimeOutHandler,id：  "+id+"\t"+"系统繁忙，请稍后在试。o(╥﹏╥)o";
    }
}
