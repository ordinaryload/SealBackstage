package load.service.serviceIml;

import load.bean.Goods;
import load.bean.GoodsExample;
import load.mapper.GoodsMapper;
import load.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    public boolean addGoods(Goods goods) {
        goods.setDate(new Date());
        if(goodsMapper.insert(goods) > 0){
            return true;
        }
        return false;
    }

    @Override
    public List<Goods> selectGoods(Goods goods) {
        GoodsExample goodsExample =new GoodsExample();
        GoodsExample.Criteria criteria = goodsExample.createCriteria();
        if (!StringUtils.isEmpty(goods.getId())) {
            criteria.andIdEqualTo(goods.getId());
        }
        if (!StringUtils.isEmpty(goods.getUsername())){
            criteria.andUsernameEqualTo(goods.getUsername());
        }
        else {
            criteria.andDateLessThan(new Date());
        }
        return goodsMapper.selectByExample(goodsExample);
    }

    @Override
    public List<Goods> getGoods(String content) {
        GoodsExample goodsExample =new GoodsExample();
        if(!StringUtils.isEmpty(content)){
            goodsExample.or().andNameLike("%"+content+"%");
            goodsExample.or().andTypeLike("%"+content+"%");
            goodsExample.or().andDetailLike("%"+content+"%");
            goodsExample.or().andVersionLike("%"+content+"%");
        }
        return goodsMapper.selectByExample(goodsExample);
    }
}
