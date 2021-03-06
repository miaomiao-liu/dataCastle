package cn.edu.swpu.cins.dataCastle.service.serviceImpl;

import cn.edu.swpu.cins.dataCastle.async.EventModel;
import cn.edu.swpu.cins.dataCastle.async.EventProducer;
import cn.edu.swpu.cins.dataCastle.async.EventType;
import cn.edu.swpu.cins.dataCastle.dao.UserDao;
import cn.edu.swpu.cins.dataCastle.model.view.LoginUser;
import cn.edu.swpu.cins.dataCastle.model.view.RegisterUser;
import cn.edu.swpu.cins.dataCastle.model.view.SignInResult;
import cn.edu.swpu.cins.dataCastle.service.AuthService;
import cn.edu.swpu.cins.dataCastle.service.MailService;
import cn.edu.swpu.cins.dataCastle.util.JedisAdapter;
import cn.edu.swpu.cins.dataCastle.util.JwtTokenUtil;
import cn.edu.swpu.cins.dataCastle.util.JwtUserFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by miaomiao on 17-9-28.
 */
@Service
public class AuthServiceImpl implements AuthService{

    @Autowired
    UserDao userDao;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtTokenUtil jwtTokenUtil;
    @Autowired
    MailService mailService;
    @Autowired
    EventProducer eventProducer;
    @Autowired
    JedisAdapter jedisAdapter;

    private static final int expires = 3 * 60;

    @Override
    public Map<Boolean,String> addUser(RegisterUser registerUser,String token) {

        Map<Boolean,String> map = new HashMap<>();
        String username = registerUser.getUsername();
        String password = registerUser.getPassword();
        String email = registerUser.getEmail();

        if(userDao.selectUser(username) != null){
            map.put(false,"用户名已存在！");
            return map;
        }
        if(userDao.existEmail(email) != null){
            map.put(false,"邮箱已被注册！");
            return map;
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        registerUser.setPassword(encoder.encode(password));
        registerUser.setEnable(0);
        registerUser.setFrequency(0);
        int line = userDao.addUser(registerUser);
        if(line == 1) {
            Map<String,String> map1 = new HashMap<>();
            map1.put("token",token);
            eventProducer.fireEvent(new EventModel().setEventType(EventType.REGISTER).setActor(username).setAccept(email).setExts(map1));
            jedisAdapter.setex(email,expires,token);
        }
        return map;
    }

    @Override
    public SignInResult login(LoginUser loginUser) {
        String username = loginUser.getUsername();
        String password = loginUser.getPassword();
        if(userDao.selectUser(loginUser.getUsername()) == null){
            return new SignInResult("没有该用户名的用户！");
        }
        if(userDao.selectUser(username).getEnable() != 1){
            return new SignInResult("请激活邮箱后再登录！");
        }
        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(username,password);
        final Authentication authentication = authenticationManager.authenticate(upToken);

        SecurityContextHolder.getContext().setAuthentication(authentication);
        final UserDetails userDetails = JwtUserFactory.createUser(userDao.selectUser(loginUser.getUsername()));
        final String token = jwtTokenUtil.generateToken(userDetails);
        SignInResult result = new SignInResult(token,username,"登录成功！");
        return result;
    }

}
