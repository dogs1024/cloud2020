import org.junit.Test;

import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @author zk
 * @version 1.0
 * @description 测试类
 * @date 2020/10/14 16:23
 */
public class Test1 {
    @Test
    public void test1(){
        //默认时区
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);      // 2020-10-14T16:44:18.011+08:00[Asia/Shanghai]
        //根据指定时区获取当前时间
        ZonedDateTime america_time = ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println(america_time);      // 2020-10-14T04:44:18.015-04:00[America/New_York]
    }
}
