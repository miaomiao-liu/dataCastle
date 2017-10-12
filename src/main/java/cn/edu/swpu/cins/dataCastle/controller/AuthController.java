package cn.edu.swpu.cins.dataCastle.controller;

import cn.edu.swpu.cins.dataCastle.enums.MatchEnum;
import cn.edu.swpu.cins.dataCastle.model.view.AuthUser;
import cn.edu.swpu.cins.dataCastle.model.view.LoginUser;
import cn.edu.swpu.cins.dataCastle.model.view.RegisterUser;
import cn.edu.swpu.cins.dataCastle.model.view.SignInResult;
import cn.edu.swpu.cins.dataCastle.service.AuthService;
import cn.edu.swpu.cins.dataCastle.service.EnableService;
import cn.edu.swpu.cins.dataCastle.service.VerifyCodeService;
import cn.edu.swpu.cins.dataCastle.util.GetUserName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.UUID;

/**
 * Created by miaomiao on 17-9-28.
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthService authService;
    @Autowired
    VerifyCodeService verifyCodeService;
    @Autowired
    GetUserName getUserName;
    @Autowired
    EnableService enableService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterUser registerUser){
        Map<Boolean,String> map;
        String token = UUID.randomUUID().toString();
        map = authService.addUser(registerUser,token);
        if(map.isEmpty()) {
            return new ResponseEntity<Object>("注册成功，请激活你的邮箱",HttpStatus.OK);
        }else {
            return new ResponseEntity<Object>(map, HttpStatus.OK);
        }
    }

    @GetMapping("/verifyCode")
    public byte[] getVerifyCode(HttpServletResponse response){
        return verifyCodeService.getVerifyCode(response);
    }

    @PostMapping("/login")
    public SignInResult login(@RequestBody LoginUser loginUser){
        return authService.login(loginUser);
    }


    @GetMapping("/enable")
    public MatchEnum enable(@RequestParam("mail") String  mail,
                            @RequestParam("token") String token){
        AuthUser authUser = new AuthUser(mail,token);
        return enableService.enable(authUser);
    }
}
