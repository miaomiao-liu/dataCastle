package cn.edu.swpu.cins.dataCastle.service;

import cn.edu.swpu.cins.dataCastle.model.view.LoginUser;
import cn.edu.swpu.cins.dataCastle.model.view.RegisterUser;

import java.util.Map;

/**
 * Created by miaomiao on 17-9-28.
 */
public interface AuthService {

    Map<Boolean,String> addUser(RegisterUser registerUser);

    String login(LoginUser loginUser);

}
