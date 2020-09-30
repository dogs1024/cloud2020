package cn.zk.springcloud.controller;

import cn.zk.springcloud.service.IPaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zk
 * @version 1.0
 * @description 消费端Hystrix服务降级
 * @date 2020/9/30 11:18
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")       //全局配置。减少代码膨胀（每个方法上配置服务降级，）没有特别指明服务降级，就用默认的服务降级
public class OrderHystirxController {

    @Resource
    private IPaymentHystrixService iPaymentHystrixService;

    //成功读取
    @GetMapping(value = "/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        return iPaymentHystrixService.paymentInfo_OK(id);
    }

    //延时读取
    @GetMapping(value = "/consumer/payment/hystrix/timeout/{id}")
/*
    注：      一般服务降级放在客户端
    服务降级：当服务端出现异常（超时、报错...等）或者自身出现异常时调备用方法paymentTimeOutFallbackMethod。友好提示用户。
    举个栗子：打客服电话时，客服繁忙时会温馨提示——按1请等待、按2请挂机稍后再拨...而不是什么都不提醒，让用户浪费时间继续等待;
              也不是将error信息报给用户让用户一头雾水
    */
    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod",commandProperties = {
            //约定当前线程超过1.5s阀值时调用paymentTimeOutFallbackMethod备用方法
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
    })
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id){
        return iPaymentHystrixService.paymentInfo_TimeOut(id);
    }

    public String paymentTimeOutFallbackMethod(@PathVariable("id") Integer id){
        return "我是消费者80端，对方系统繁忙请稍后再试 & 自身运行出错请检查自己  o(╥﹏╥)o";
    }

    // 下面是全局fallback方法
    public String payment_Global_FallbackMethod()
    {
        return "Global异常处理信息，请稍后再试，/(ㄒoㄒ)/~~";
    }
}
