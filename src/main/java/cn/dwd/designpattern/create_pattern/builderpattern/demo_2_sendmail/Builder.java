package cn.dwd.designpattern.create_pattern.builderpattern.demo_2_sendmail;

import javax.mail.Address;
import javax.mail.MessagingException;

/**
 * 描述:构造器Builder的统一接口,此处是邮件构造器.
 * Created by xiaoyanzi on 16/5/1.
 */
public interface Builder {

    /**
     * 发件人
     */
    void buildFrom() throws Exception;

    /**
     * 收件人
     */
    void buildRecipient(String recipient)throws Exception;

    /**
     * 主题
     */
    void buildSubject(String subject) throws Exception;

    /**
     * 构建session
     */
    void buildSession(String smtpHost);

    /**
     * 内容
     */
    void buildContent(String content) throws Exception;

    /**
     * 构建权限
     */
    void buildAuthenticator(String username , String password);


    void buildMessage();

    /**
     * 发送邮件
     */
    void send() throws MessagingException;

}
