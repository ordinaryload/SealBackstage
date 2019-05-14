package load.service.serviceIml;

import load.bean.Orders;
import load.bean.OrdersExample;
import load.entity.param.OrderParam;
import load.enumcollection.OrderStatusEnum;
import load.mapper.OrdersMapper;
import load.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrdersMapper orderMapper;


    @Override
    public void insertOrder(Orders order) {
        order.setDate(new Date());
        order.setStatus(OrderStatusEnum.NEW_ORDER.getOrder());
        orderMapper.insertSelective(order);
    }


    @Override
    public List<Orders> selectOrderByExample(OrdersExample orderExample) {
        return orderMapper.selectByExample(orderExample);
    }

    @Override
    public int updateByConditon(Orders orders) {
        OrdersExample ordersExample=new OrdersExample();
        OrdersExample.Criteria criteria = ordersExample.createCriteria();
        if(!StringUtils.isEmpty(orders.getBuyer())){
            criteria.andBuyerEqualTo(orders.getBuyer());
        }
        if(!StringUtils.isEmpty(orders.getId())){
            criteria.andIdEqualTo(orders.getId());
        }
        return orderMapper.updateByExampleSelective(orders,ordersExample);
    }

    @Override
    public List<Orders> getOrders(OrderParam orderParam) {
        OrdersExample ordersExample=new OrdersExample();
        OrdersExample.Criteria criteria = ordersExample.createCriteria();
        wrapConditon(criteria,orderParam);
        List<Orders> orders = orderMapper.selectByExample(ordersExample);
        return orders;
    }
    private void wrapConditon(OrdersExample.Criteria criteria,OrderParam orderParam){
        if(!StringUtils.isEmpty(orderParam.getBuyer())){
            criteria.andBuyerEqualTo(orderParam.getBuyer());
        }

        if(!StringUtils.isEmpty(orderParam.getDate())){
            criteria.andDateEqualTo(orderParam.getDate());
        }
        if(!StringUtils.isEmpty(orderParam.getGoodsid())){
            criteria.andGoodsidEqualTo(orderParam.getGoodsid());
        }
        if(!StringUtils.isEmpty(orderParam.getId())){
            criteria.andIdEqualTo(orderParam.getId());
        }
        if(!StringUtils.isEmpty(orderParam.getStatus())){
            criteria.andStatusEqualTo(orderParam.getStatus());
        }
    }
}
