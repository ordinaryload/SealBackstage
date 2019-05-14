package load.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import load.bean.Reply;
import load.constant.SealConstants;
import load.entity.param.ReplyParam;
import load.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public String addReply(@RequestBody Reply reply){
        JSONObject jsonObject = new JSONObject();
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
        List<Reply> reply = replyService.getReply(replyParam);
        Map<String,Object> returnMap=new HashMap<>();
        returnMap.put("state",SealConstants.SUCCESS);
        returnMap.put("data",reply);
        return objectMapper.writeValueAsString(returnMap);
    }


}
