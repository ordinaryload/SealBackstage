package load.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import load.bean.Message;
import load.bean.User;
import load.bean.po.MessageVo;
import load.constant.SealConstants;
import load.entity.param.MessageParam;
import load.service.MessageService;
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
@RequestMapping("message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * 增加聊天模块
     * @param message
     * @param httpSession
     * @return
     */
    @RequestMapping(value = "message",method = RequestMethod.PUT)
    @ResponseBody
    public String addMessage(@RequestBody Message message, HttpSession httpSession){
        User user = (User)httpSession.getAttribute("tUser");
        JSONObject jsonObject = new JSONObject();
        if(user == null){
            jsonObject.put("state",SealConstants.fail);
            jsonObject.put("message","用户未登录");
            return jsonObject.toJSONString();
        }
        message.setPutrole(user.getUsername());
        messageService.insertMessage(message);
        jsonObject.put("state", SealConstants.SUCCESS);
        return jsonObject.toJSONString();
    }

    /**
     * 删除聊天
     * @param message
     * @return
     */
    @RequestMapping(value = "message",method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteMessage(@RequestBody Message message){
        messageService.deleteByCondition(message);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("state",SealConstants.SUCCESS);
        return jsonObject.toJSONString();
    }

    /**
     * 修改聊天信息
     * @param message
     * @return
     */
    @RequestMapping(value = "message",method = RequestMethod.POST)
    @ResponseBody
    public String updateMessage(@RequestBody Message message){
        messageService.updateByCondition(message);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("state",SealConstants.SUCCESS);
        return jsonObject.toJSONString();
    }

    /**
     * 查看聊天记录
     * @param messageParam
     * @return
     */
    @RequestMapping(value = "message",method = RequestMethod.GET)
    @ResponseBody
    public String getMessage(MessageParam messageParam) throws Exception{
        List<Message> message = messageService.getMessage(messageParam);
        Map<String,Object> returnMap=new HashMap<>();
        returnMap.put("state",SealConstants.SUCCESS);
        List<MessageVo> list=(List<MessageVo>)load.tools.BeanUtils.copyProperties(message,MessageVo.class);

        returnMap.put("data",list);
        return objectMapper.writeValueAsString(returnMap);
    }

}
