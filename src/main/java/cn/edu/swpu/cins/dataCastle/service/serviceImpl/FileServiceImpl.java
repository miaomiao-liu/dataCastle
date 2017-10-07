package cn.edu.swpu.cins.dataCastle.service.serviceImpl;

import cn.edu.swpu.cins.dataCastle.dao.UserDao;
import cn.edu.swpu.cins.dataCastle.enums.MatchEnum;
import cn.edu.swpu.cins.dataCastle.service.FileService;
import cn.edu.swpu.cins.dataCastle.service.RankListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by miaomiao on 17-9-29.
 */
@Service
public class FileServiceImpl implements FileService {

    @Value("${dataCastle.location}")
    private String location;
    @Autowired
    UserDao userDao;
    @Autowired
    RankListService rankListService;

    @Override
    public Map<Boolean, String> upload(MultipartFile multipartFile,String username) {
        int groupId = userDao.selectUser(username).getGroupId();
        Map<Boolean,String> map = new HashMap<>();
        String path = location + "/" +groupId;

        File file = new File(path);
        if(file.exists()){
            //删除已存在文件
            file.delete();
        }
        try {
            multipartFile.transferTo(file);
            MatchEnum status= rankListService.addGroupDate(groupId,new Date());
            map.put(true,"上传成功" + status);
        } catch (IOException e) {
            e.printStackTrace();
            map.put(true,"上传失败");
        }
        return map;
    }

}
