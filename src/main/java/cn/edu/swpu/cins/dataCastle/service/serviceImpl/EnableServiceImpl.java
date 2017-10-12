package cn.edu.swpu.cins.dataCastle.service.serviceImpl;

import cn.edu.swpu.cins.dataCastle.dao.UserDao;
import cn.edu.swpu.cins.dataCastle.enums.MatchEnum;
import cn.edu.swpu.cins.dataCastle.model.view.AuthUser;
import cn.edu.swpu.cins.dataCastle.service.EnableService;
import cn.edu.swpu.cins.dataCastle.util.JedisAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by miaomiao on 17-10-8.
 */
@Service
public class EnableServiceImpl implements EnableService {

    @Autowired
    UserDao userDao;
    @Autowired
    JedisAdapter jedisAdapter;

    @Override
    public MatchEnum enable(AuthUser authUser) {

        MatchEnum verifyResult = verifyToken(authUser.getMail(),authUser.getToken());
        if(verifyResult == MatchEnum.ENABLE_TOKEN_SUCCESS) {
            int enable = 1;
            userDao.updateEnable(enable, authUser.getMail());
            return MatchEnum.UPDATE_SUCCESS;
        }
        return verifyResult;
    }

    private MatchEnum verifyToken(String mail,String token){
        String enableToken = jedisAdapter.get(mail);
        if (enableToken == null){
            return MatchEnum.ENABLE_TOKEN_TIMEOUT;
        }
        if (!enableToken.equals(token)){
            return MatchEnum.ENABLE_TOKEN_INVALID;
        }
        return MatchEnum.ENABLE_TOKEN_SUCCESS;
    }

}
