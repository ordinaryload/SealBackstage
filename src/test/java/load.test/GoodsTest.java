package load.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import load.bean.Goods;
import org.junit.Test;
import load.service.GoodsService;
import load.service.serviceIml.GoodsServiceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        GoodsService goodsService=new GoodsServiceImpl();
        goodsService.addGoods(goods);
    }


    @Test
    public void testJson() throws Exception{
        List<Goods> goods=new ArrayList<>();
        Goods goods1=new Goods();
        Goods goods2=new Goods();
        goods.add(goods1);
        goods.add(goods2);
        goods1.setName("abc");
        goods2.setName("def");
        JSONArray jsonArray=new JSONArray();
        for (Goods key:goods) {
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("id",key.getId());
            jsonObject.put("price",key.getPrice());
            jsonObject.put("images",key.getImages());
            jsonObject.put("name",key.getName());
            jsonObject.put("sold",key.getSold()==null?0:key.getSold());
            jsonObject.put("type",key.getType());
            jsonObject.put("version",key.getVersion());
            jsonArray.add(jsonObject);
        }
        System.out.println(jsonArray.toString());
        ObjectMapper objectMapper=new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        System.out.println(objectMapper.writeValueAsString(goods));


    }
}
