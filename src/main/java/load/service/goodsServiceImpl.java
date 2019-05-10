package load.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import load.bean.Goods;
import load.bean.GoodsExample;
import load.mapper.GoodsMapper;

import java.util.Date;
import java.util.List;

@Service
public class goodsServiceImpl implements goodsService{

    @Autowired
    private GoodsMapper goodsMapper;

    public boolean addGoods(Goods goods) {
        Date date=new Date();
        goods.setDate(date);
        if(goodsMapper.insert(goods)>0){
            return true;
        }
        return false;
    }


    public List<Goods> selectGoods(String username) {
        GoodsExample goodsExample =new GoodsExample();
        GoodsExample.Criteria criteria = goodsExample.createCriteria();
        if (username!=null){
            criteria.andUsernameEqualTo(username);
        }else {
            criteria.andDateLessThan(new Date());
        }
        return goodsMapper.selectByExample(goodsExample);
    }



    public List<Goods> getGoods(String content) {
        GoodsExample goodsExample =new GoodsExample();
        GoodsExample.Criteria criteria=goodsExample.createCriteria();
        if(content.equals("$home")){
                criteria.andDateLessThan(new Date());
                return goodsMapper.selectByExample(goodsExample);
        }else {
            goodsExample.or().andNameLike("%"+content+"%");
            goodsExample.or().andNameLike("%"+content+"%");
            goodsExample.or().andTypeLike("%"+content+"%");
            goodsExample.or().andDetailLike("%"+content+"%");
            goodsExample.or().andVersionLike("%"+content+"%");
            return goodsMapper.selectByExample(goodsExample);
        }
    }
}
