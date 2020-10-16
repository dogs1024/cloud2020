package cn.zk.springcloud.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zk
 * @version 1.0
 * @description config客户端读取config服务端配置
 * @date 2020/10/16 16:38
 */
@RestController
@RefreshScope       //config服务端自动刷新。客户端需要手动刷新。调外置Post刷新接口。
public class ConfigClientController {
    //获取config服务端配置的默认分支
    @Value("${config.info}")
    private String configInfo;

    //返回默认分支
    @GetMapping("/configInfo")
    public String getConfigInfo(){
        return configInfo;
    }
}
