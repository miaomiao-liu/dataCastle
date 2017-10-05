package cn.edu.swpu.cins.dataCastle.model.view;

/**
 * Created by miaomiao on 17-9-28.
 */
public class RegisterUser {
    private String username;
    private String password;
    private String email;
    private int enable;

    public RegisterUser() {
    }

    public RegisterUser(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEnable() {
        return enable;
    }

    public void setEnable(int enable) {
        this.enable = enable;
    }
}
