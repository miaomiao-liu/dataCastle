package cn.edu.swpu.cins.dataCastle.controller;

import cn.edu.swpu.cins.dataCastle.model.view.LoginUser;
import cn.edu.swpu.cins.dataCastle.model.view.RegisterUser;
import cn.edu.swpu.cins.dataCastle.model.view.SignInResult;
import cn.edu.swpu.cins.dataCastle.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by miaomiao on 17-9-28.
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterUser registerUser){
        Map<Boolean,String> map = new HashMap();
        map = authService.addUser(registerUser);
        if(map.isEmpty()) {
            return new ResponseEntity<Object>("注册成功，请激活你的邮箱",HttpStatus.OK);
        }else {
            return new ResponseEntity<Object>(map, HttpStatus.OK);
        }
    }

    @PostMapping("/login")
    public SignInResult login(@RequestBody LoginUser loginUser){
        return authService.login(loginUser);
    }
}
