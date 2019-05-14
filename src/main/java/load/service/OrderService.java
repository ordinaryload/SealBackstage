package load.service;

import load.bean.*;
import load.entity.param.OrderParam;

import java.util.List;

public interface OrderService {

    /**
     *
     * @param order
     */
    void insertOrder(Orders order);


    /**
     *
     * @param orderExample
     * @return
     */
    List<Orders> selectOrderByExample(OrdersExample orderExample);


    /**
     * 修改订单
     * @param orders
     * @return
     */
    int updateByConditon(Orders orders);

    /**
     * 获取订单
     * @param orderParam
     * @return
     */
    List<Orders> getOrders(OrderParam orderParam);
}
