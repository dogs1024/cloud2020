package cn.zk.springcloud.service.impl;

import cn.zk.springcloud.dao.PaymentDao;
import cn.zk.springcloud.entities.Payment;
import cn.zk.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zk
 * @version 1.0
 * @description
 * @date 2020/8/27 14:13
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    //@Autowired      //spring的注解。依赖注入
    @Resource       //jdk自带的。依赖注入
    private PaymentDao paymentDao;


    @Override
    public int creat(Payment payment) {
        return paymentDao.creat(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
