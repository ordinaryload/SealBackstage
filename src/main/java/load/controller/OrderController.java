package load.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import load.bean.Orders;
import load.bean.User;
import load.constant.SealConstants;
import load.entity.param.OrderParam;
import load.service.OrderService;
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
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * 添加订单
     * @param order
     * @param httpSession
     * @return
     */
    @RequestMapping(value = "order",method = RequestMethod.PUT)
    @ResponseBody
    public String addOrder(@RequestBody Orders order, HttpSession httpSession){
        User user =(User) httpSession.getAttribute("tUser");
        JSONObject jsonObject=new JSONObject();
        if(user==null){
            jsonObject.put("state", SealConstants.fail);
            jsonObject.put("message","用户未登录");
            return jsonObject.toJSONString();
        }
        order.setBuyer(user.getUsername());
        orderService.insertOrder(order);
        jsonObject.put("state", SealConstants.SUCCESS);
        return jsonObject.toJSONString();
    }

    /**
     *更新订单
     * @param order
     * @return
     */
    @RequestMapping(value = "order",method = RequestMethod.POST)
    @ResponseBody
    public String updateOrder(@RequestBody Orders order){
        orderService.updateByConditon(order);
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("state", SealConstants.SUCCESS);
        return jsonObject.toJSONString();
    }


    /**
     * 获取订单
     * @param orderParam
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "order",method = RequestMethod.GET)
    @ResponseBody
    public String getOrder(OrderParam orderParam) throws Exception{
       List<Orders> orders= orderService.getOrders(orderParam);
       Map<String,Object> returnMap=new HashMap<>();
       returnMap.put("state",SealConstants.SUCCESS);
       returnMap.put("data",orders);
       return objectMapper.writeValueAsString(returnMap);
    }
}
