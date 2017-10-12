package cn.edu.swpu.cins.dataCastle.service;

import javax.mail.MessagingException;

/**
 * Created by miaomiao on 17-9-29.
 */
public interface MailService {

    void registerMail(String username, String mail,String token) throws MessagingException;
}
