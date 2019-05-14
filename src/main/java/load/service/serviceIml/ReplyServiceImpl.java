package load.service.serviceIml;

import load.bean.Reply;
import load.bean.ReplyExample;
import load.entity.param.ReplyParam;
import load.mapper.ReplyMapper;
import load.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    private ReplyMapper replyMapper;



    @Override
    public void insertReply(Reply reply) {
        reply.setRea("false");
        reply.setDate(new Date());
        replyMapper.insertSelective(reply);
    }



    @Override
    public int deleteByCondition(Reply reply) {
        ReplyExample replyExample = new ReplyExample();
        ReplyExample.Criteria criteria = replyExample.createCriteria();
        if(!StringUtils.isEmpty(reply.getId())){
            criteria.andIdEqualTo(reply.getId());
        }
        return replyMapper.deleteByExample(replyExample);
    }

    @Override
    public int updateByCondition(Reply reply) {
        ReplyExample replyExample = new ReplyExample();
        ReplyExample.Criteria criteria = replyExample.createCriteria();
        if(!StringUtils.isEmpty(reply.getId())){
            criteria.andIdEqualTo(reply.getId());
        }
        return replyMapper.updateByExampleSelective(reply,replyExample);
    }

    @Override
    public List<Reply> getReply(ReplyParam replyParam) {
        ReplyExample replyExample = new ReplyExample();
        ReplyExample.Criteria criteria = replyExample.createCriteria();
        wrapCondition(criteria,replyParam);
        List<Reply> replies = replyMapper.selectByExample(replyExample);
        return replies;
    }

    private void wrapCondition(ReplyExample.Criteria criteria,ReplyParam replyParam){
        if(!StringUtils.isEmpty(replyParam.getDate())){
            criteria.andDateEqualTo(replyParam.getDate());
        }
        if(!StringUtils.isEmpty(replyParam.getId())){
            criteria.andIdEqualTo(replyParam.getId());
        }
        if(!StringUtils.isEmpty(replyParam.getImages())){
            criteria.andImagesEqualTo(replyParam.getImages());
        }
        if(!StringUtils.isEmpty(replyParam.getMsgid())){
            criteria.andMsgidEqualTo(replyParam.getMsgid());
        }
        if(!StringUtils.isEmpty(replyParam.getRead())){
            criteria.andReaEqualTo(replyParam.getRead());
        }
        if(!StringUtils.isEmpty(replyParam.getText())){
            criteria.andTextEqualTo(replyParam.getText());
        }
        if(!StringUtils.isEmpty(replyParam.getType())){
            criteria.andTypeEqualTo(replyParam.getType());
        }
    }
}
