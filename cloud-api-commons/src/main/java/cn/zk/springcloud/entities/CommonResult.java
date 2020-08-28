package cn.zk.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zk
 * @version 1.0
 * @description 统一传给前端的Json串。前端不在关心后台的业务实体类。
 * @date 2020/8/27 11:37
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    //状态码。例如：200——成功，404——找不到资源
    private Integer code;
    private String message;
    private T data;

    //考虑到后期data可能为null，需要自定义构造
    public CommonResult(Integer code,String message){
        this(code,message,null);
    }
}

