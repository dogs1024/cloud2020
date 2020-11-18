package cn.zk.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author zk
 * @version 1.0
 * @description dao层的配置
 * @date 2020/11/18 17:22
 */
@Configuration
@MapperScan({"cn.zk.springcloud.dao"})
public class MyBatisConfig {
}
