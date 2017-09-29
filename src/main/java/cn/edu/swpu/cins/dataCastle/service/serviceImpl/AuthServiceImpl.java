package cn.edu.swpu.cins.dataCastle.service.serviceImpl;

import cn.edu.swpu.cins.dataCastle.dao.UserDao;
import cn.edu.swpu.cins.dataCastle.model.view.LoginUser;
import cn.edu.swpu.cins.dataCastle.model.view.RegisterUser;
import cn.edu.swpu.cins.dataCastle.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by miaomiao on 17-9-28.
 */
@Service
public class AuthServiceImpl implements AuthService{

    @Autowired
    UserDao userDao;

    @Override
    public Map<Boolean,String> addUser(RegisterUser registerUser) {

        Map<Boolean,String> map = new HashMap<>();
        String username = registerUser.getUsername();
        String password = registerUser.getPassword();
        String email = registerUser.getEmail();

        if(userDao.existUsername(username) != null){
            map.put(false,"用户名已存在！");
            return map;
        }
        if(userDao.existUsername(email) != null){
            map.put(false,"邮箱已被注册！");
            return map;
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        registerUser.setPassword(encoder.encode(password));

        userDao.addUser(registerUser);
        return map;
    }

    @Override
    public String login(LoginUser loginUser) {

        String username = loginUser.getUsername();
        String passworld = loginUser.getPassword();

        return null;
    }


}
