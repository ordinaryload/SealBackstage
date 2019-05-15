package load.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetNowDate {
   public static String Date(){
       SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
       String nowTime=df.format(new Date());
       System.out.println(nowTime);// new Date()为获取当前系统时间
       return nowTime;
   }
}
