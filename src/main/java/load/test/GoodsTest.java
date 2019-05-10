package load.test;

import org.junit.Test;
import load.bean.Goods;
import load.service.goodsService;
import load.service.goodsServiceImpl;

import java.util.Date;

public class GoodsTest {

    @Test
    public void getInset(){
        Goods goods=new Goods();
//        测试数据
        Date date=new Date();
        String username="test1";
        String name="商品名称";
        String type="数码残品";
        Float aFloat=new Float("998.99");
        String detail="产品介绍";
        int sold=999;
        goods.setDate(date);
        goods.setUsername(username);
        goods.setDetail(detail);
        goods.setName(name);
        goods.setType(type);
        goods.setPrice(aFloat);
        goods.setSold(sold);
//        打印时间
//        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        System.out.println(format.format(date));
        goodsService goodsService=new goodsServiceImpl();
        goodsService.addGoods(goods);
    }
}
