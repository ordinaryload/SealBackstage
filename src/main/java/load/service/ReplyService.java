package load.service;

import load.bean.Reply;
import load.entity.param.ReplyParam;

import java.util.List;

public interface ReplyService {

    /**
     * 插入评论
     * @param reply
     */
    void insertReply(Reply reply);


    int deleteByCondition(Reply reply);

    int updateByCondition(Reply reply);

    List<Reply> getReply(ReplyParam replyParam);
}
