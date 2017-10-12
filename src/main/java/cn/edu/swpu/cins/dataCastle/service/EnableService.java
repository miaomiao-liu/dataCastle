package cn.edu.swpu.cins.dataCastle.service;

import cn.edu.swpu.cins.dataCastle.enums.MatchEnum;
import cn.edu.swpu.cins.dataCastle.model.view.AuthUser;

/**
 * Created by miaomiao on 17-10-8.
 */
public interface EnableService {

    MatchEnum enable(AuthUser authUser);
}
