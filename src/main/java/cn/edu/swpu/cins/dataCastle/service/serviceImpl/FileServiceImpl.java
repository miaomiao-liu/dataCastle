package cn.edu.swpu.cins.dataCastle.service.serviceImpl;

import cn.edu.swpu.cins.dataCastle.dao.UserDao;
import cn.edu.swpu.cins.dataCastle.enums.MatchEnum;
import cn.edu.swpu.cins.dataCastle.exception.FileException;
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
        Map<Boolean,String> map = new HashMap<>();
        if(userDao.selectUser(username).getFrequency() >= 2){
            map.put(false,"上传次数已达上线！");
            return map;
        }
        int groupId = userDao.selectUser(username).getGroupId();
        Date date = new Date();
        String path = checkDir(groupId);
        path = path + "/" + date;

        File file = new File(path);
//        if(file.exists()){
//            //删除已存在文件
//            file.delete();
//        }
        try {
            multipartFile.transferTo(file);
            userDao.addFrequency(username);
            MatchEnum status= rankListService.addGroupDate(groupId,date);
            map.put(true,"上传成功" + status);
        } catch (IOException e) {
            e.printStackTrace();
            map.put(true,"上传失败");
        }
        return map;
    }

    private String checkDir(int groupId){
        String path = location + "/" + groupId;
        File dir = new File(path);
        if (!dir.exists()) {
            if (!dir.mkdirs()) {
                throw new FileException("create dir failed");
            }
        }
        return path;
    }

}
