package cn.zk.springcloud.service;

/**
 * @auther zk
 * @create 2020年11月18日18:26:18
 */
public interface StorageService {
    /**
     * 扣减库存
     */
    void decrease(Long productId, Integer count);
}
