package cn.zk.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import cn.zk.springcloud.service.IPaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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
        return "线程池：" + Thread.currentThread().getName() + "   paymentInfo_OK,id：  " + id + "\t" + "我是正常访问    O(∩_∩)O";
    }

    //注：一般服务降级放在客户端
    //服务降级.模拟失败，测试Hystrix断路器
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
            //约定当前线程超过3s阀值时调用paymentInfo_TimeOutHandler备用方法
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
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
        return "线程池：" + Thread.currentThread().getName() + "   paymentInfo_TimeOut,id：  " + id + "\t" + "我是延时访问   耗时（s）ヽ(#`Д´)ﾉ┌┛〃：" + timeNum;
    }

    //服务降级->备用方法->超时/报错后使用兜底的方法来替代原方法
    public String paymentInfo_TimeOutHandler(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "   paymentInfo_TimeOutHandler,id：  " + id + "\t" + "系统繁忙，请稍后在试。o(╥﹏╥)o";
    }

    //服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),  //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),   //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),  //时间范围/时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"), //失败率达到多少后跳闸。
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if (id < 0) {
            throw new RuntimeException("*****id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName() + "\t" + "调用成功,流水号：" + serialNumber;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id) {
        return "id 不能负数，请稍候再试,(┬＿┬)/~~     id: " + id;
    }

}
