package cn.edu.swpu.cins.dataCastle.dao;

import cn.edu.swpu.cins.dataCastle.model.property.User;
import cn.edu.swpu.cins.dataCastle.model.view.RegisterUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by miaomiao on 17-9-28.
 */
@Repository
@Mapper
public interface UserDao {

    int addUser(RegisterUser registerUser);

    int updateEnable(@Param("enable")int enable,
                     @Param("email")String email);

    User existEmail(String email);

    User selectUser(String username);

    int updateGroupId(@Param("username") String username,
                      @Param("groupId") int groupId);

}
