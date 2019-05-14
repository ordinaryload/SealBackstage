package load.service.serviceIml;

import load.bean.Message;
import load.bean.MessageExample;
import load.entity.param.MessageParam;
import load.mapper.MessageMapper;
import load.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageMapper messageMapper;

    @Override
    public void insertMessage(Message message) {
        message.setDate(new Date());
        messageMapper.insertSelective(message);
    }

    @Override
    public int deleteByCondition(Message message) {
        MessageExample messageExample = new MessageExample();
        MessageExample.Criteria criteria = messageExample.createCriteria();
        if(!StringUtils.isEmpty(message.getPutrole())){
            criteria.andPutroleEqualTo(message.getPutrole());
        }
        if(!StringUtils.isEmpty(message.getId())){
            criteria.andIdEqualTo(message.getId());
        }
        return messageMapper.deleteByExample(messageExample);
    }

    @Override
    public int updateByCondition(Message message) {
        MessageExample messageExample = new MessageExample();
        MessageExample.Criteria criteria = messageExample.createCriteria();
        if(!StringUtils.isEmpty(message.getPutrole())){
            criteria.andPutroleEqualTo(message.getPutrole());
        }
        if(!StringUtils.isEmpty(message.getId())){
            criteria.andIdEqualTo(message.getId());
        }
        return messageMapper.updateByExampleSelective(message,messageExample);
    }

    @Override
    public List<Message> getMessage(MessageParam messageParam) {
        MessageExample messageExample = new MessageExample();
        MessageExample.Criteria criteria = messageExample.createCriteria();
        wrapCondition(criteria,messageParam);
        List<Message> messages = messageMapper.selectByExample(messageExample);
        return messages;
    }

    private void wrapCondition(MessageExample.Criteria criteria,MessageParam messageParam){
        if(!StringUtils.isEmpty(messageParam.getPutrole())){
            criteria.andPutroleEqualTo(messageParam.getPutrole());
        }
        if(!StringUtils.isEmpty(messageParam.getId())){
            criteria.andIdEqualTo(messageParam.getId());
        }
        if(!StringUtils.isEmpty(messageParam.getImages())){
            criteria.andImagesEqualTo(messageParam.getImages());
        }
        if(!StringUtils.isEmpty(messageParam.getText())){
            criteria.andTextEqualTo(messageParam.getText());
        }
        if(!StringUtils.isEmpty(messageParam.getGetrole())){
            criteria.andGetroleEqualTo(messageParam.getGetrole());
        }
        if(!StringUtils.isEmpty(messageParam.getDate())){
            criteria.andDateEqualTo(messageParam.getDate());
        }

    }
}
