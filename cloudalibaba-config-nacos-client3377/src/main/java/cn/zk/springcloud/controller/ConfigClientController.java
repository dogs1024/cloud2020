package cn.zk.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zk
 * @version 1.0
 * @description 读取Nacos配置中心 中的配置文件信息
 * @date 2020/10/26 17:54
 */
@RestController
@RefreshScope           //SpringCloud原生注解实现配置自动刷新
public class ConfigClientController
{
    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/config/info")
    public String getConfigInfo() {
        return configInfo;
    }
}
