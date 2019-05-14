package load.service;

import load.bean.Message;
import load.entity.param.MessageParam;
import java.util.List;

public interface MessageService {

    void insertMessage(Message message);

    int deleteByCondition(Message message);

    int updateByCondition(Message message);

    List<Message> getMessage(MessageParam messageParam);

}
