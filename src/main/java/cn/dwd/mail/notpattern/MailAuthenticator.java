package cn.dwd.mail.notpattern;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * 描述:权限类
 * Created by xiaoyanzi on 16/4/26.
 */
public class MailAuthenticator extends Authenticator {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    public MailAuthenticator(String username,String password){
        this.username = username;
        this.password = password;
    }

    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(username,password);
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
}
