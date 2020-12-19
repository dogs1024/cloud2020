import cn.hutool.Hutool;
import cn.hutool.core.util.IdUtil;

/**
 * @author zk
 * @version 1.0
 * @description 测试
 * @date 2020/12/18 17:34
 */
public class Test {
    @org.junit.Test
    public void test1(){
        System.out.println(IdUtil.randomUUID());
        System.out.println(IdUtil.simpleUUID());
    }
}

