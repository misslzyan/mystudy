package cn.dwd.designpattern.create_pattern.builderpattern.demo_2_sendmail;

/**
 * 知道mailbuilder来构建邮件
 * Created by xiaoyanzi on 16/5/1.
 */
public class MailDirector {

   private  Builder builder ;

    public MailDirector(Builder builder) {
        this.builder = builder;
    }

    /**
     * 构造邮件
     * @param username 用户名
     * @param password 密码
     * @param smtpHost 邮箱域名
     * @param recipient 收件人
     * @param subject 主题
     * @param content 内容
     * @throws Exception
     */
    public void constructMail(String username,String password , String smtpHost,String recipient,String subject , String content) throws Exception{
        builder.buildAuthenticator(username,password);
        builder.buildSession(smtpHost);
        builder.buildMessage();
        builder.buildFrom();
        builder.buildRecipient(recipient);
        builder.buildSubject(subject);
        builder.buildContent(content);

    }

    public void constructMailDef(String username,String password ,String recipient,String subject , String content) throws Exception{
        String smtpHost = "smtp."+username.substring(username.indexOf("@")+1);
        constructMail(username,password,smtpHost,recipient,subject,content);
    }
}
