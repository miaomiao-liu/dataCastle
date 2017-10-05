package cn.edu.swpu.cins.dataCastle.util;

import cn.edu.swpu.cins.dataCastle.model.property.User;
import cn.edu.swpu.cins.dataCastle.model.view.JwtUser;


/**
 * Created by miaomiao on 17-10-5.
 */
public class JwtUserFactory {

    public JwtUserFactory() {
    }

    public static JwtUser createUser(User user){
        return new JwtUser(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getEmail()
        );
    }
}
