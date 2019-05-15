package load.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import load.bean.Communicate;
import load.bean.User;
import load.bean.po.CommunicateVo;
import load.constant.SealConstants;
import load.entity.param.CommunicateParam;
import load.entity.po.CommunicatePo;
import load.service.CommunicateService;
import org.springframework.beans.BeanUtils;
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
@RequestMapping("communicate")
public class CommunicateController {

    @Autowired
    private CommunicateService communicateService;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * 发布论坛内容
     * @param communicate
     * @param httpSession
     * @return
     */
    @RequestMapping(value = "communicate",method = RequestMethod.PUT)
    @ResponseBody
    public String addCommunicate(@RequestBody Communicate communicate, HttpSession httpSession){
        User user = (User)httpSession.getAttribute("tUser");
        JSONObject jsonObject = new JSONObject();
        if(user == null){
            jsonObject.put("state", SealConstants.fail);
            jsonObject.put("message","用户未登录");
            return jsonObject.toJSONString();
        }
        communicate.setUsername(user.getUsername());
        communicateService.insertCommunicate(communicate);
        jsonObject.put("state",SealConstants.SUCCESS);
        return jsonObject.toJSONString();
    }

    /**
     * 删除论坛交流
     * @param communicate
     * @return
     */
    @RequestMapping(value = "communicate",method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteCommunicate(@RequestBody Communicate communicate){
        communicateService.deleteByCondition(communicate);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("state",SealConstants.SUCCESS);
        return jsonObject.toJSONString();
    }

    /**
     * 修改论坛信息
     * @param communicate
     * @return
     */
    @RequestMapping(value = "communicate",method = RequestMethod.POST)
    @ResponseBody
    public String updateCommunicate(@RequestBody Communicate communicate){
        communicateService.updateByCondition(communicate);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("state",SealConstants.SUCCESS);
        return jsonObject.toJSONString();
    }

    /**
     * 查看论坛信息
     * @param communicateParam
     * @return
     */
    @RequestMapping(value = "communicate",method = RequestMethod.GET)
    @ResponseBody
    public String getCommunicate(CommunicateParam communicateParam) throws Exception{
        List<Communicate> communicate = communicateService.getCommunicate(communicateParam);
        BeanUtils.copyProperties(communicate,CommunicateVo.class);
        Map<String,Object> returnMap=new HashMap<>();
        returnMap.put("state",SealConstants.SUCCESS);
        List<CommunicateVo> list=(List<CommunicateVo>)load.tools.BeanUtils.copyProperties(communicate,CommunicateVo.class);
        returnMap.put("data",list);
        return objectMapper.writeValueAsString(returnMap);
    }

    /**
     * 查看论坛信息
     * @param communicateParam
     * @return
     */
    @RequestMapping(value = "communicateAndReply",method = RequestMethod.GET)
    @ResponseBody
    public String getCommunicateAndReply(CommunicateParam communicateParam) throws Exception{
        List<CommunicatePo> communicate = communicateService.getCommunicateAndReply(communicateParam);
        Map<String,Object> returnMap=new HashMap<>();
        returnMap.put("state",SealConstants.SUCCESS);
        returnMap.put("data",communicate);
        return objectMapper.writeValueAsString(returnMap);
    }
}
