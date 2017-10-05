package cn.edu.swpu.cins.dataCastle.model.view;

import cn.edu.swpu.cins.dataCastle.model.property.User;

/**
 * Created by miaomiao on 17-10-5.
 */
public class SignInResult {

    private String token;
    private int id;
    private String username;
    private String email;
    private String status;

    public SignInResult() {
    }

    public SignInResult(String status) {
        this.status = status;
    }

    public SignInResult(String token,String username,String status) {
        this.token = token;
        this.username = username;
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
