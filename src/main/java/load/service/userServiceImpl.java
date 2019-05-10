package load.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import load.bean.User;
import load.bean.UserExample;
import load.mapper.UserMapper;

import java.util.List;

@Service
public class userServiceImpl implements userService{

    @Autowired
    private UserMapper userMapper;

    public User login(String email, String password) {
        UserExample example=new UserExample();
        UserExample.Criteria criteria=example.createCriteria();
        criteria.andEmailEqualTo(email).andPasswordEqualTo(password);
        List<User> users = userMapper.selectByExample(example);
        if(users.isEmpty())
        return null;
        else{
            return users.get(0);
        }
    }

    public boolean regist(User user) {
        if(isUserExist(user.getEmail())){
            return false;
        }else{
            user.setStatus(1);
            userMapper.insert(user);
            return true;
        }

    }


    public boolean isUserExist(String email) {
        UserExample example=new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andEmailEqualTo(email);
        List<User> users = userMapper.selectByExample(example);
        if (users.isEmpty())
        return false;
        else {
            return true;
        }
    }

}
