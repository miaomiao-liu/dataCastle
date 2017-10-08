package cn.edu.swpu.cins.dataCastle.service.serviceImpl;

import cn.edu.swpu.cins.dataCastle.dao.UserDao;
import cn.edu.swpu.cins.dataCastle.enums.MatchEnum;
import cn.edu.swpu.cins.dataCastle.service.EnableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by miaomiao on 17-10-8.
 */
@Service
public class EnableServiceImpl implements EnableService {

    @Autowired
    UserDao userDao;

    @Override
    public MatchEnum enable(String username) {
        int enable = 1;
        userDao.updateEnable(enable,username);
        return MatchEnum.UPDATE_SUCCESS;
    }

}
