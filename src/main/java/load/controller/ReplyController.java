package load.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import load.bean.Reply;
import load.bean.User;
import load.bean.po.OrdersVo;
import load.bean.po.ReplyVo;
import load.constant.SealConstants;
import load.entity.param.ReplyParam;
import load.entity.po.ReplyPo;
import load.service.ReplyService;
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
@RequestMapping("reply")
public class ReplyController {

    @Autowired
    private ReplyService replyService;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * 添加评论
     * @param reply
     * @return
     */
    @RequestMapping(value = "reply",method = RequestMethod.PUT)
    @ResponseBody
    public String addReply(@RequestBody Reply reply, HttpSession httpSession ){
        User user =(User) httpSession.getAttribute("tUser");
        JSONObject jsonObject = new JSONObject();
        if(user==null){
            jsonObject.put("state", SealConstants.fail);
            jsonObject.put("message","用户未登录");
            return jsonObject.toJSONString();
        }
        reply.setUsername(user.getUsername());
        replyService.insertReply(reply);
        jsonObject.put("state", SealConstants.SUCCESS);
        return jsonObject.toJSONString();
    }

    /**
     * 删除评论
     * @param reply
     * @return
     */
    @RequestMapping(value = "reply",method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteReply(@RequestBody Reply reply){
        JSONObject jsonObject = new JSONObject();
        replyService.deleteByCondition(reply);
        jsonObject.put("state",SealConstants.SUCCESS);
        return jsonObject.toJSONString();

    }


    /**
     * 修改评论
     * @param reply
     * @return
     */
    @RequestMapping(value = "reply",method = RequestMethod.POST)
    @ResponseBody
    public String updateReply(@RequestBody Reply reply){
        replyService.updateByCondition(reply);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("state",SealConstants.SUCCESS);
        return jsonObject.toJSONString();
    }

    /**
     * 查看评论
     * @param replyParam
     * @return
     */
    @RequestMapping(value = "reply",method = RequestMethod.GET)
    @ResponseBody
    public String getReply(ReplyParam replyParam) throws Exception{
        List<Reply> replies = replyService.getReply(replyParam);
        Map<String,Object> returnMap=new HashMap<>();
        returnMap.put("state",SealConstants.SUCCESS);
        List<ReplyPo> list=(List<ReplyPo>)load.tools.BeanUtils.copyProperties(replies,ReplyPo.class);
        returnMap.put("data",list);
        return objectMapper.writeValueAsString(returnMap);
    }


}
