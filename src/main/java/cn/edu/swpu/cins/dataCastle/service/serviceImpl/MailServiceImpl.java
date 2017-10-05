package cn.edu.swpu.cins.dataCastle.service.serviceImpl;

import cn.edu.swpu.cins.dataCastle.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * Created by miaomiao on 17-9-29.
 */
@Service
public class MailServiceImpl implements MailService{

    @Autowired
    private JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private String fromMail;

    @Override
    public void registerMail(String username, String toMail) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(fromMail);
        mailMessage.setTo(toMail);
        mailMessage.setSubject(subject(username));
        mailMessage.setText(context());
        javaMailSender.send(mailMessage);
    }


    private String subject(String username){
        final String subject = "亲爱的username，欢迎注册大叔据月的竞赛活动";
        return subject.replace("username",username);
    }

    // .....
    private String context(){
        final String context = "请访问以下地址，激活你的邮箱";
        return context;
    }

}
