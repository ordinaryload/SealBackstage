package load.listener;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.io.IOException;

public class SealApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private ObjectMapper objectMapper;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("容器加载完成");

        objectMapper.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {
        @Override
        public void serialize(Object arg0, JsonGenerator arg1, SerializerProvider arg2) throws IOException, JsonProcessingException {
            arg1.writeString("");
            }
        });

//        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }
}
