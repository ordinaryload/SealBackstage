package load.service;

import load.bean.Goods;

import java.util.List;

public interface GoodsService {
    /**
     * 新增货品信息
     * @param goods
     * @return 增加成功True 否则false
     */
     boolean addGoods(Goods goods);

    /**
     * 获取商家货物列表
     * @param username
     * @return
     */
     List<Goods> selectGoods(Goods username);

    /**
     * 首页获取商品列表
     * @param content ($home或likeText)
     * @return
     */
     List<Goods> getGoods(String content);
}
