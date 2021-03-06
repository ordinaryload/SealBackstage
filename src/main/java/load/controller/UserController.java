package load.controller;

import com.alibaba.fastjson.JSONObject;
import load.bean.User;
import load.constant.SealConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import load.service.UserService;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户登录接口
     * @return String
     */
    @RequestMapping(value = "login",method = RequestMethod.POST)
    @ResponseBody
    public String login(@RequestBody User tuser, HttpSession httpSession){
        //获取账号密码
        JSONObject jsonObject=new JSONObject();
        String email = tuser.getEmail();
        String password = tuser.getPassword();

        //如果有一个为空
        if(email==null||password==null){
            jsonObject.put("state", SealConstants.fail);
            return jsonObject.toJSONString();
        }
        //查询数据
        User user=userService.login(email,password);
        if (user!=null){
            httpSession.setAttribute("tUser",user);
            User test= (User) httpSession.getAttribute("tUser");
            System.out.println(test);
            String sessionId = httpSession.getId();
            jsonObject.put("state",SealConstants.SUCCESS);
            jsonObject.put("token",sessionId);
            jsonObject.put("power",user.getPower());
            return jsonObject.toJSONString();
        }else{
            jsonObject.put("state",SealConstants.fail);
            return jsonObject.toJSONString();
        }
    }

    /**
     * 用户注册接口
     * @param user
     * @return String
     */
    @RequestMapping(value = "user",method = RequestMethod.PUT)
    @ResponseBody
    public String regist(@RequestBody User user){
        JSONObject jsonObject=new JSONObject();
        user.setUsername(user.getEmail());
        if(userService.regist(user)){
            jsonObject.put("state",SealConstants.SUCCESS);
            return jsonObject.toJSONString();
        }else{
            jsonObject.put("state",SealConstants.fail);
            return jsonObject.toJSONString();
        }
    }
    /**
     * 获取个人信息
     * @return String
     */
    @RequestMapping(value = "user",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getPersonalinfo(HttpSession httpSession){
        User user =(User) httpSession.getAttribute("tUser");
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("email",user.getEmail());
        jsonObject.put("nickname",user.getNickname());
        return jsonObject.toJSONString();
    }


}
