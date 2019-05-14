package load.listener;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class SealApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private ObjectMapper objectMapper;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("容器加载完成");
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }
}
