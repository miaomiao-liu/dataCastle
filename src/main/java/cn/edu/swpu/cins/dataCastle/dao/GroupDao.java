package cn.edu.swpu.cins.dataCastle.dao;

import cn.edu.swpu.cins.dataCastle.model.property.Group;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * Created by miaomiao on 17-9-28.
 */
@Repository
@Mapper
public interface GroupDao {

    int addGroup(Group group);

    String selectGroup(int groupId);

    int selectFrequency(int groupId);

    int addFrequency(int groupId);

    int updateFrequency();


}
