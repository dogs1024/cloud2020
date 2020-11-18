package cn.zk.springcloud.controller;

import cn.zk.springcloud.po.Order;
import cn.zk.springcloud.service.IOrderService;
import cn.zk.springcloud.vo.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zk
 * @version 1.0
 * @description
 * @date 2020/11/18 17:24
 */
@RestController
public class OrderController {
    @Resource
    private IOrderService iOrderService;

    @GetMapping("/order/create")
    public CommonResult create(Order order)
    {
        iOrderService.create(order);
        return new CommonResult(200,"订单创建成功");
    }
}
