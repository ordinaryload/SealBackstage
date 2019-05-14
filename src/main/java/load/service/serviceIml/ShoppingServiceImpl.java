package load.service.serviceIml;

import load.bean.Shopping;
import load.bean.ShoppingExample;
import load.entity.param.ShoppingParam;
import load.mapper.ShoppingMapper;
import load.service.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

@Service
public class ShoppingServiceImpl implements ShoppingService {

    @Autowired
    private ShoppingMapper shoppingMapper;

    @Override
    public void insertShopping(Shopping shopping) {
        shopping.setDate(new Date());
        shoppingMapper.insertSelective(shopping);
    }

    @Override
    public int updateByConditon(Shopping shopping) {
        ShoppingExample shoppingExample = new ShoppingExample();
        ShoppingExample.Criteria criteria = shoppingExample.createCriteria();

        if(!StringUtils.isEmpty(shopping.getBuyer())){
            criteria.andBuyerEqualTo(shopping.getBuyer());
        }
        if(!StringUtils.isEmpty(shopping.getId())){
            criteria.andIdEqualTo(shopping.getId());
        }
        return shoppingMapper.updateByExampleSelective(shopping,shoppingExample);
    }

    @Override
    public int deleteByCondition(Shopping shopping){
        ShoppingExample shoppingExample = new ShoppingExample();
        ShoppingExample.Criteria criteria = shoppingExample.createCriteria();
        if(!StringUtils.isEmpty(shopping.getBuyer())){
            criteria.andBuyerEqualTo(shopping.getBuyer());
        }
        if(!StringUtils.isEmpty(shopping.getId())){
            criteria.andIdEqualTo(shopping.getId());
        }
        return shoppingMapper.deleteByExample(shoppingExample);
    }

    @Override
    public List<Shopping> getOrders(ShoppingParam shoppingParam) {
        ShoppingExample shoppingExample = new ShoppingExample();
        ShoppingExample.Criteria criteria = shoppingExample.createCriteria();
        wrapConditon(criteria,shoppingParam);
        List<Shopping> shopping = shoppingMapper.selectByExample(shoppingExample);
        return shopping;
    }
    private void wrapConditon(ShoppingExample.Criteria criteria, ShoppingParam shoppingParam){
        if(!StringUtils.isEmpty(shoppingParam.getBuyer())){
            criteria.andBuyerEqualTo(shoppingParam.getBuyer());
        }
        if(!StringUtils.isEmpty(shoppingParam.getDate())){
            criteria.andDateEqualTo(shoppingParam.getDate());
        }
        if(!StringUtils.isEmpty(shoppingParam.getGoodsid())){
            criteria.andGoodsidEqualTo(shoppingParam.getGoodsid());
        }
        if(!StringUtils.isEmpty(shoppingParam.getId())){
            criteria.andIdEqualTo(shoppingParam.getId());
        }

    }


}
