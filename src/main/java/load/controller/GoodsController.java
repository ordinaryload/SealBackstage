package load.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import load.bean.Goods;
import load.bean.User;
import load.bean.po.GoodsVo;
import load.constant.SealConstants;
import load.tools.GetNowDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import load.service.GoodsService;
import load.tools.randomString;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * 发布新的商品
     * @param goods
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "good",method = RequestMethod.PUT)
    public String pubNewgoods(@RequestBody Goods goods, HttpSession session){
        JSONObject jsonObject=new JSONObject();
        User user = (User) session.getAttribute("tUser");
        goods.setUsername(user.getUsername());
        goodsService.addGoods(goods);
        session.removeAttribute("images");
        jsonObject.put("state", SealConstants.SUCCESS);
        return jsonObject.toJSONString();
    }


    /**
     * 商家获取发布的商品
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "good" ,method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public String getGoodsList(HttpSession session,Goods goods) throws Exception{
        User user= (User) session.getAttribute("tUser");
        if (user==null)
            return SealConstants.fail;
        List<Goods> goods1 = goodsService.selectGoods(goods);
        Map<String,Object> returnMap=new HashMap<>();
        returnMap.put("state",SealConstants.SUCCESS);
        List<GoodsVo> list=(List<GoodsVo>)load.tools.BeanUtils.copyProperties(goods1,GoodsVo.class);
        returnMap.put("data",list);
        return objectMapper.writeValueAsString(returnMap);

    }

    /**
     * 获取商品列表
     * @param content
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "goods",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public String getGoodsList(@RequestParam(value="content",required = false) String content){
        //mode (home/search)
        List<Goods> goods = goodsService.getGoods(content);
        JSONArray jsonArray=new JSONArray();
        if(goods!=null)
        for (Goods key:goods
        ) {
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
        return jsonArray.toJSONString();
    }

    /**
     * 保存图片png/jpg
     * @param request
     * @return
     */
    @RequestMapping(value = "image", method = RequestMethod.POST)
    @ResponseBody
    public String saveimgUrls(HttpServletRequest request){
        //获取项目根目录
        String rootPath = System.getProperty("seal");
        //获取文件流
        MultipartHttpServletRequest req = (MultipartHttpServletRequest) request;
        MultipartFile multipartFile = req.getFile("file");
        //获取保存文件的路径
        String realPath = rootPath + "upload/images";
        //获取原文件名
        String originalFilename=multipartFile.getOriginalFilename();
        System.out.println(originalFilename);
        //获取原文件类型
        String contentType = originalFilename.substring(originalFilename.lastIndexOf("."));
        System.out.println(contentType);
        try {
            File dir = new File(realPath);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            //生成随机文件名
            String filename = randomString.getRandomString(20) + GetNowDate.Date();
            filename+=contentType;

            File file = new File(realPath, filename);
            multipartFile.transferTo(file);//写出文件

            return "upload/images/"+filename;//返回给前端

        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
        return SealConstants.fail;
    }

}
