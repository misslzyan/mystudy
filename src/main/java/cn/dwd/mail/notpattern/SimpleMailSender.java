package cn.dwd.mail.notpattern;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * 描述:邮件发送
 * Created by xiaoyanzi on 16/4/26.
 */
public class SimpleMailSender {

    /**
     * 发送邮件的props文件
     */
    private transient Properties props = System.getProperties();


    /**
     * 邮件服务器登录验证
     */
    private transient MailAuthenticator authenticator;

    private transient Session session;

    public SimpleMailSender(final String smtpHostName , final String username , final String password){
        init(smtpHostName,username,password);
    }

    private void init(String smtpHostName, String username , String password){

        //初始化props
        props.put("mail.smtp.auth","true");
        props.put("mail.smtp.host",smtpHostName);

        //验证
        authenticator = new MailAuthenticator(username,password);

        session = Session.getInstance(props,authenticator);

    }

    public void send(String recipient,String subject ,Object content) throws AddressException,MessagingException {
        //创建Mime类邮件
        final MimeMessage message = new MimeMessage(session);

        //设置发信人

        message.setFrom(new InternetAddress(authenticator.getUsername()));

        //设置收信人

        message.setRecipient(MimeMessage.RecipientType.TO,new InternetAddress(recipient));

        //设置主题

        message.setSubject(subject);

        //设置邮件内容

        message.setContent(content.toString(),"text/html;charset=utf-8");

        //发送

        Transport.send(message);
    }
}
