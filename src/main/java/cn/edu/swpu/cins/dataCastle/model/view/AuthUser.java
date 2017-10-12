package cn.edu.swpu.cins.dataCastle.model.view;

/**
 * Created by miaomiao on 17-10-8.
 */
public class AuthUser {

    private String mail;
    private String token;

    public AuthUser() {
    }

    public AuthUser(String mail, String token) {
        this.mail = mail;
        this.token = token;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
