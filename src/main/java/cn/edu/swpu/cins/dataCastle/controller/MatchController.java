package cn.edu.swpu.cins.dataCastle.controller;

import cn.edu.swpu.cins.dataCastle.enums.MatchEnum;
import cn.edu.swpu.cins.dataCastle.enums.UserEnum;
import cn.edu.swpu.cins.dataCastle.model.view.GroupWithMemberName;
import cn.edu.swpu.cins.dataCastle.service.EnableService;
import cn.edu.swpu.cins.dataCastle.service.FileService;
import cn.edu.swpu.cins.dataCastle.service.GroupService;
import cn.edu.swpu.cins.dataCastle.util.GetUserName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by miaomiao on 17-10-5.
 */
@RestController
@RequestMapping("/match")
public class MatchController {

    @Autowired
    GroupService groupService;
    @Autowired
    FileService fileService;
    @Autowired
    EnableService enableService;
    @Autowired
    GetUserName getUserName;

    @PostMapping("/joinGroup")
    public UserEnum matchGroup(@RequestBody GroupWithMemberName groupWithMemberName){
        return groupService.addGroup(groupWithMemberName);
    }


    @PostMapping("/upload")
    public Map<Boolean, String> upload(@RequestParam MultipartFile multipartFile,
                                       @RequestParam String username){
        return fileService.upload(multipartFile,username);
    }

    @PostMapping("/enable")
    public MatchEnum enable(HttpServletRequest request){
        String username = getUserName.getUsernameFromRequest(request);
        return enableService.enable(username);
    }
}
