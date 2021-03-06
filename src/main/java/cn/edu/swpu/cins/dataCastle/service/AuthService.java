package cn.edu.swpu.cins.dataCastle.service;

import cn.edu.swpu.cins.dataCastle.model.view.LoginUser;
import cn.edu.swpu.cins.dataCastle.model.view.RegisterUser;
import cn.edu.swpu.cins.dataCastle.model.view.SignInResult;

import java.util.Map;

/**
 * Created by miaomiao on 17-9-28.
 */
public interface AuthService {

    Map<Boolean,String> addUser(RegisterUser registerUser,String token);

    SignInResult login(LoginUser loginUser);

}
