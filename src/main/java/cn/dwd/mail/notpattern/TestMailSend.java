package cn.dwd.mail.notpattern;

/**
 * Created by xiaoyanzi on 16/4/26.
 */
public class TestMailSend {

    public static void main(String[] args) throws Exception{
        SimpleMailSender sender = new SimpleMailSender("smtp.163.com","13552627021@163.com","miss111");
        sender.send("532808406@qq.com","javamail","woshihaha");

        System.out.println("success send");

        System.out.println(System.getProperty("java.home"));
        System.out.println(System.getenv("JAVA_HOME"));
    }
}
