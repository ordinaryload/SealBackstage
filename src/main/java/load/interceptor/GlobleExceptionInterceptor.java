package load.interceptor;

import load.constant.SealConstants;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class GlobleExceptionInterceptor implements HandlerExceptionResolver {


    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        MappingJackson2JsonView view = new MappingJackson2JsonView();
        modelAndView.setView(view);
        e.printStackTrace();
        if(e instanceof Exception){
            modelAndView.addObject("state" ,SealConstants.fail);
            modelAndView.addObject("message","未知异常");
        }

        return modelAndView;
    }
}
