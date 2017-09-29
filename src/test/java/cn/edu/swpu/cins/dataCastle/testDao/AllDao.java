package cn.edu.swpu.cins.dataCastle.testDao;

import cn.edu.swpu.cins.dataCastle.dao.UserDao;
import cn.edu.swpu.cins.dataCastle.model.view.RegisterUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by miaomiao on 17-9-28.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AllDao {

    @Autowired
    UserDao userDao;

    @Test
    public void userDao(){
        RegisterUser registerUser = new RegisterUser();
        registerUser.setUsername("miaomiao");
        registerUser.setPassword("124");
        registerUser.setEmail("244w6");

        userDao.addUser(registerUser);

    }
}
