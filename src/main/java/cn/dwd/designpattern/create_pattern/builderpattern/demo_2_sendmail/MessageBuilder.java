package cn.dwd.designpattern.create_pattern.builderpattern.demo_2_sendmail;

import cn.dwd.designpattern.create_pattern.builderpattern.demo_1.*;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.net.InetAddress;
import java.util.Properties;

/**
 * Created by xiaoyanzi on 16/5/1.
 */
public class MessageBuilder implements Builder {

    private transient Properties props=System.getProperties();

    /**
     * 权限
     */
    private MailAuthenticator authenticator;

    /**
     * 邮件
     */
    private Message message;

    /**
     * mail session
     */
    private Session session;




    @Override
    public void buildFrom() throws Exception {
        this.message.setFrom(new InternetAddress(authenticator.getUsername()));
    }

    @Override
    public void buildRecipient(String recipient) throws Exception{
        this.message.setRecipient(Message.RecipientType.TO,new InternetAddress(recipient));
    }

    @Override
    public void buildSubject(String subject) throws Exception{
        this.message.setSubject(subject);
    }



    @Override
    public void buildSession(String smtpHost) {
        if(authenticator==null){
            throw new RuntimeException("authenticarot is null");
        }
        props.put("mail.smtp.auth","true");
        props.put("mail.smtp.host",smtpHost);
//        props.put("mail.smtp.auth","true");
//        props.put("mail.smtp.host",smtpHostName);
        this.session = Session.getInstance(props,authenticator);
    }

    @Override
    public void buildContent(String content) throws Exception {
        this.message.setContent(content,"text/html;charset=utf-8");
    }

    @Override
    public void buildAuthenticator( String username, String password) {
        this.authenticator =new MailAuthenticator(username,password);
    }

    @Override
    public void buildMessage() {
        if(session == null){
            throw new RuntimeException("session is null");
        }
        this.message = new MimeMessage(session);
    }

    @Override
    public void send() throws MessagingException {
        Transport.send(this.message);
    }
}
