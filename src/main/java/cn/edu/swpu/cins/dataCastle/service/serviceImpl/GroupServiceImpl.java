package cn.edu.swpu.cins.dataCastle.service.serviceImpl;

import cn.edu.swpu.cins.dataCastle.dao.GroupDao;
import cn.edu.swpu.cins.dataCastle.model.property.Group;
import cn.edu.swpu.cins.dataCastle.model.view.GroupWithMemberName;
import cn.edu.swpu.cins.dataCastle.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by miaomiao on 17-9-28.
 */
public class GroupServiceImpl implements GroupService {

    @Autowired
    GroupDao groupDao;

    @Override
    public void addGroup(GroupWithMemberName groupWithMemberName) {
        String groupName = groupWithMemberName.getGroupName();
        Group group = new Group(groupName);
        groupDao.addGroup(group);


    }
}
