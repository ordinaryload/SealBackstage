package load.service;

import load.bean.Communicate;
import load.entity.param.CommunicateParam;

import java.util.List;

public interface CommunicateService {

    void insertCommunicate(Communicate communicate);

    int deleteByCondition(Communicate communicate);

    int updateByCondition(Communicate communicate);

    List<Communicate> getCommunicate(CommunicateParam communicateParam);
}
