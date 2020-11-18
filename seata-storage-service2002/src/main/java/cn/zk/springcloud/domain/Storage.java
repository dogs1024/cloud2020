package cn.zk.springcloud.domain;

import lombok.Data;

/**
 * @auther zk
 * @create 2020年11月18日18:26:18
 */
@Data
public class Storage {

    private Long id;

    /**
     * 产品id
     */
    private Long productId;

    /**
     * 总库存
     */
    private Integer total;

    /**
     * 已用库存
     */
    private Integer used;

    /**
     * 剩余库存
     */
    private Integer residue;
}
