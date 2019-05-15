package load.service;

import load.bean.Communicate;
import load.bean.po.CommunicateVo;
import load.entity.param.CommunicateParam;
import load.entity.po.CommunicatePo;

import java.util.List;

public interface CommunicateService {

    void insertCommunicate(Communicate communicate);

    int deleteByCondition(Communicate communicate);

    int updateByCondition(Communicate communicate);

    List<Communicate> getCommunicate(CommunicateParam communicateParam);
    List<CommunicatePo> getCommunicateAndReply(CommunicateParam communicateParam);

}
