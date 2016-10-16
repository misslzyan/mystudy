package cn.dwd.xor;

import javax.mail.Address;
import java.util.ArrayList;
import java.util.List;

/**
 * 利用异或对数据进行加密
 * Created by xiaoyanzi on 16/10/10.
 */
public class AddSecret {

    public static void main(String[] args) {
        char c1 = '我';
        char c2 = '是';
        char c3 = '人';
        char secret = '%';
        char s1 = (char)(c1^secret);
        char s2 = (char)(c2^secret);
        char s3 = (char)(c3^secret);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        int n1 = s1^secret;
        int n2 = s2^secret;
        int n3 = s3^secret;
        System.out.println((char)n1);
        System.out.println((char)n2);
        System.out.println((char)n3);
        List<AddSecret>  list = new ArrayList<>();

        while(true){
            for(int i = 0;i<500;i++){

                AddSecret a = new AddSecret();
                list.add(a);
            }
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
