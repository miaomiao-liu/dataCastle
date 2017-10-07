package cn.edu.swpu.cins.dataCastle.service.serviceImpl;

import cn.edu.swpu.cins.dataCastle.dao.GroupDao;
import cn.edu.swpu.cins.dataCastle.dao.UserDao;
import cn.edu.swpu.cins.dataCastle.enums.UserEnum;
import cn.edu.swpu.cins.dataCastle.model.property.Group;
import cn.edu.swpu.cins.dataCastle.model.property.User;
import cn.edu.swpu.cins.dataCastle.model.view.GroupWithMemberName;
import cn.edu.swpu.cins.dataCastle.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by miaomiao on 17-9-28.
 */
@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    GroupDao groupDao;
    @Autowired
    UserDao userDao;

    @Override
    public UserEnum addGroup(GroupWithMemberName groupWithMemberName) {
        String groupName = groupWithMemberName.getGroupName();
        List<String> members= groupWithMemberName.getGroupMembers();
        Group group = new Group(groupName);
        if(groupDao.addGroup(group) != 1){
            return UserEnum.SAVE_FAILED;
        }
        int groupId = group.getId();
        for (String member : members) {
            userDao.updateGroupId(member,groupId);
        }
        return UserEnum.SAVE_SUCCESS;
    }

}
