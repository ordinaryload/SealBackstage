package load.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import load.bean.Shopping;
import load.bean.User;
import load.constant.SealConstants;
import load.entity.param.ShoppingParam;
import load.service.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("shopping")
public class ShoppingController {

    @Autowired
    private ShoppingService shoppingService;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * 加入购物车
     * @param shopping,
     * @param httpSession
     * @return
     */
    @RequestMapping(value = "shopping",method = RequestMethod.PUT)
    @ResponseBody
    public String addShopping(@RequestBody Shopping shopping, HttpSession httpSession){
        User user =(User) httpSession.getAttribute("tUser");
        JSONObject jsonObject=new JSONObject();
        if(user==null){
            jsonObject.put("state", SealConstants.fail);
            jsonObject.put("message","用户未登录");
            return jsonObject.toJSONString();
        }
        shopping.setBuyer(user.getUsername());
        shoppingService.insertShopping(shopping);
        jsonObject.put("state", SealConstants.SUCCESS);
        return jsonObject.toJSONString();
    }

    /**
     * 删除购物车商品
     * @param shopping
     * @return
     */
    @RequestMapping(value = "shopping",method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteShopping(@RequestBody Shopping shopping){
        shoppingService.deleteByCondition(shopping);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("state",SealConstants.SUCCESS);
        return jsonObject.toJSONString();
    }

    /**
     * 修改购物车
     * @param shopping
     * @return
     */
    @RequestMapping(value = "shopping",method = RequestMethod.POST)
    @ResponseBody
    public String updateShopping(@RequestBody Shopping shopping){
        shoppingService.updateByConditon(shopping);
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("state", SealConstants.SUCCESS);
        return jsonObject.toJSONString();
    }

    /**
     * 获取购物车
     * @param shoppingParam
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "shopping",method = RequestMethod.GET)
    @ResponseBody
    public String getOrder(ShoppingParam shoppingParam) throws Exception{
        List<Shopping> shopping = shoppingService.getOrders(shoppingParam);
        Map<String,Object> returnMap=new HashMap<>();
        returnMap.put("state",SealConstants.SUCCESS);
        returnMap.put("data",shopping);
        return objectMapper.writeValueAsString(returnMap);
    }

}
