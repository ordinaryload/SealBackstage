package load.mapper.mr;

import load.entity.param.CommunicateParam;
import load.entity.po.CommunicatePo;
import load.mapper.CommunicateMapper;

import java.util.List;

public interface MrCommunicateMapper extends CommunicateMapper {
    List<CommunicatePo> getCommunicateAndReply(CommunicateParam communicateParam);
}
