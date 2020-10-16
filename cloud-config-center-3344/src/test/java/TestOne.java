import cn.hutool.core.util.IdUtil;
import org.junit.Test;

/**
 * @author zk
 * @version 1.0
 * @description
 * @date 2020/10/16 10:13
 */
public class TestOne {
    @Test
    public void test1(){
        String s1 = IdUtil.simpleUUID();
        System.out.println(s1);
        String s = IdUtil.randomUUID();
        System.out.println(s);
    }
}
