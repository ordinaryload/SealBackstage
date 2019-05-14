package load.tools;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import load.bean.po.CommunicateVo;

import java.util.List;

public class BeanUtils {
    static ObjectMapper objectMapper=new ObjectMapper();
    public static <T>  Object copyProperties(List list,Class cla) throws Exception{
        String str=objectMapper.writeValueAsString(list);
        CollectionType collectionType = objectMapper.getTypeFactory().constructCollectionType(List.class, cla);
        return objectMapper.readValue(str, collectionType);
    }
}
