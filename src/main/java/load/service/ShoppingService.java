package load.service;

import load.bean.Shopping;
import load.entity.param.ShoppingParam;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ShoppingService {

    void insertShopping(Shopping shopping);

    int updateByConditon(Shopping shopping);

    int deleteByCondition(Shopping shopping);

    List<Shopping> getOrders(ShoppingParam shoppingParam);
}
