package cn.edu.swpu.cins.dataCastle.service;

import cn.edu.swpu.cins.dataCastle.enums.UserEnum;
import cn.edu.swpu.cins.dataCastle.model.view.GroupWithMemberName;

/**
 * Created by miaomiao on 17-9-28.
 */
public interface GroupService {

    UserEnum addGroup(GroupWithMemberName groupWithMemberName);
}
