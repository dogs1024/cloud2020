package cn.zk.springcloud.service;

import cn.zk.springcloud.po.Order;

/**
 * @author zk
 * @version 1.0
 * @description 订单
 * @date 2020/11/18 17:53
 */
public interface IOrderService {
    void create(Order order);
}
