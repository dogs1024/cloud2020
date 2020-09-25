package cn.zk.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zk
 * @version 1.0
 * @description 轮询负载均衡算法。参照IRule接口的RoundRobinRule实现类。
 * @date 2020/9/25 16:59
 */
/**
 * 踩到一个坑，有一个接口，在这个接口的实现类里，需要用到@Autowired注解，一时大意，没有在实现类上加上@Component注解，导致了Spring报错，找不到这个类
 * 一旦使用关于Spring的注解出现在类里，例如我在实现类中用到了@Autowired注解，被注解的这个类是从Spring容器中取出来的，那调用的实现类也需要被Spring容器管理，加上@Component
 * （把普通pojo实例化到spring容器中，相当于配置文件中的）
 * 泛指各种组件，就是说当我们的类不属于各种归类的时候（不属于@Controller、@Services等的时候），我们就可以使用@Component来标注这个类。
 */
@Component //把实现类交给spring容器管理
public class MyLB implements LoadBalancer {

    //初始化访问次数
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    //坐标
    private final int getContIncrement() {
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            next = current >= 2147483647 ? 0 : current + 1;
        } while (!this.atomicInteger.compareAndSet(current, next));//第一个参数是期望值，第二个参数是修改值。
        System.out.println("==================访问次数 -> next：" + next);
        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> instances) {//得到服务机器的列表
        int index = getContIncrement() % instances.size();//得到服务器的下标
        return instances.get(index);
    }
}
