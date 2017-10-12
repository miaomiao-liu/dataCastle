package cn.edu.swpu.cins.dataCastle.service.serviceImpl;

import cn.edu.swpu.cins.dataCastle.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * Created by miaomiao on 17-9-29.
 */
@Service
public class MailServiceImpl implements MailService{

    @Autowired
    private JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private String fromMail;
    @Value("${server.host}")
    private String host;
    @Value("${server.port}")
    private int port;
    @Value("${dataCastle.path.auth.enable}")
    private String enablePath;


    @Override
    public void registerMail(String username, String toMail,String token) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,false,"utf-8");
        helper.setFrom(fromMail);
        helper.setTo(toMail);
        helper.setText(context(toMail,token),true);
        helper.setSubject(subject(username));
        javaMailSender.send(message);
    }


    private String subject(String username){
        final String subject = "亲爱的username，欢迎注册大叔据月的竞赛活动";
        return subject.replace("username",username);
    }

    // .....
    private String context(String mail,String token){
        final String context = "请访问以下地址，激活你的邮箱(有效时间为3分钟)";
        String link = "http://"+ host + ':' + port + "/" + enablePath + "?mail=" +	mail + "&token=" + token;
        String htmlLink = "<a href='" + link + "' target='_blank'>" + link + "</a>";
        return context + htmlLink;
    }

}
