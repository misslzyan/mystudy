package cn.dwd.designpattern.create_pattern.builderpattern.demo_2_sendmail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * Created by xiaoyanzi on 16/5/1.
 */
public class MailAuthenticator extends Authenticator {

    private String password;

    private String username;

    public MailAuthenticator(String username, String password) {
        this.password = password;
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(this.username,this.password);
    }
}
