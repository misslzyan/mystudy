package cn.dwd.algorithm;

/**
 * 描述:输入一行字符，分别统计出其中英文字母、空格、数字和其它字符的个数。

 1.程序分析：利用while语句,条件为输入的字符不为 ‘\n ‘.
 * Created by xiaoyanzi on 16/4/11.
 */
public class Algorithm_7 {

    public static void answer(String str){
        int charNum = 0;
        int konggeNum =0;
        int intNum=0;
        int otherNum =0;
        for(char temp : str.toCharArray()){
            if(temp>='A'&&temp<='z'){
                charNum++;
                continue;
            }
            if(temp==' '){
                konggeNum++;
                continue;
            }
            if(temp>='0'&&temp<='9'){
                intNum++;
                continue;
            }
            otherNum++;
        }
        System.out.println(charNum);
        System.out.println(konggeNum);
        System.out.println(intNum);
        System.out.println(otherNum);
    }

    public static void main(String[] args) {
        answer("abc 234ASD中国");
    }
}
