package cn.edu.swpu.cins.dataCastle.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * Created by miaomiao on 17-9-29.
 */
public interface FileService {

    Map<Boolean,String> upload(MultipartFile multipartFile,String username);

}
