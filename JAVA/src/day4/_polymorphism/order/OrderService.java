package day4._polymorphism.order;

/**
 * 订单业务接口
 */
public interface OrderService {
    /**
     * 查询单个订单
     */
    void create();

    /**
     * 查询单个订单
     */
    void findOne();

    /**
     * 查询订单列表
     */
    void findList();

    /**
     * 取消订单
     */
    void cancel();

    /**
     * 完结订单
     */
    void finish();

    /**
     * 支付订单
     */
    void paid();
}

