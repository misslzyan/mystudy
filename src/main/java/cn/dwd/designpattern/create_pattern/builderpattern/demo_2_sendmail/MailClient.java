package cn.dwd.designpattern.create_pattern.builderpattern.demo_2_sendmail;

/**
 * Created by xiaoyanzi on 16/5/1.
 */
public class MailClient {

    public static void main(String[] args) throws Exception {
        Builder builder = new MessageBuilder();

        MailDirector  director = new MailDirector(builder);
                              //13552627021@163.com
        director.constructMailDef("13552627021@163.com","miss111","ytlzyan@163.com","小老婆","小老婆,你丑萌丑萌的~");

        builder.send();

        System.out.println("chenggong");
    }
}
