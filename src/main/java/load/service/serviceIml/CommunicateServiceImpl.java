package load.service.serviceIml;

import load.bean.Communicate;
import load.bean.CommunicateExample;
import load.entity.param.CommunicateParam;
import load.mapper.CommunicateMapper;
import load.service.CommunicateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import java.util.Date;
import java.util.List;

@Service
public class CommunicateServiceImpl implements CommunicateService {

    @Autowired
    private CommunicateMapper communicateMapper;

    @Override
    public void insertCommunicate(Communicate communicate) {
        communicate.setDate(new Date());
        communicateMapper.insertSelective(communicate);
    }

    @Override
    public int deleteByCondition(Communicate communicate) {
        CommunicateExample communicateExample = new CommunicateExample();
        CommunicateExample.Criteria criteria = communicateExample.createCriteria();
        if(!StringUtils.isEmpty(communicate.getUsername())){
            criteria.andUsernameEqualTo(communicate.getUsername());
        }
        if(!StringUtils.isEmpty(communicate.getId())){
            criteria.andIdEqualTo(communicate.getId());
        }
        return communicateMapper.deleteByExample(communicateExample);
    }

    @Override
    public int updateByCondition(Communicate communicate) {
        CommunicateExample communicateExample = new CommunicateExample();
        CommunicateExample.Criteria criteria = communicateExample.createCriteria();
        if(!StringUtils.isEmpty(communicate.getUsername())){
            criteria.andUsernameEqualTo(communicate.getUsername());
        }
        if(!StringUtils.isEmpty(communicate.getId())) {
            criteria.andIdEqualTo(communicate.getId());
        }
        return communicateMapper.updateByExampleSelective(communicate,communicateExample);
    }

    @Override
    public List<Communicate> getCommunicate(CommunicateParam communicateParam) {
        CommunicateExample communicateExample = new CommunicateExample();
        CommunicateExample.Criteria criteria = communicateExample.createCriteria();
        wrapCondition(criteria,communicateParam);
        List<Communicate> communicates = communicateMapper.selectByExample(communicateExample);
        return communicates;

    }

    private void wrapCondition(CommunicateExample.Criteria criteria, CommunicateParam communicateParam){
        if(!StringUtils.isEmpty(communicateParam.getDate())){
            criteria.andDateEqualTo(communicateParam.getDate());
        }
        if(!StringUtils.isEmpty(communicateParam.getId())){
            criteria.andIdEqualTo(communicateParam.getId());
        }
        if(!StringUtils.isEmpty(communicateParam.getImages())){
            criteria.andImagesEqualTo(communicateParam.getImages());
        }
        if(!StringUtils.isEmpty(communicateParam.getText())){
            criteria.andTextEqualTo(communicateParam.getText());
        }
        if(!StringUtils.isEmpty(communicateParam.getType())){
            criteria.andTypeEqualTo(communicateParam.getType());
        }
        if(!StringUtils.isEmpty(communicateParam.getUsername())){
            criteria.andUsernameEqualTo(communicateParam.getUsername());
        }
    }
}
