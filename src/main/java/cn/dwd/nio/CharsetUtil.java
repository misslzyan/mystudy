package cn.dwd.nio;

/**
 * 描述:编码工具类
 * Created by xiaoyanzi on 16/4/19.
 */
public class CharsetUtil {

    /**
     * 给一个UTF-8编码的字节数组,然后给出该数组中汉字的字节长度
     * 返回值-1表示不存在一个完整的字符
     * @param array
     * @return
     */
    public static int position(byte[] array){

        for(int i =0;i<array.length;){
            byte temp = array[i];
            if((temp>>7&1)==0){
            //如果temp的最高位字节是0,则代表是英文字符,如果最高位是1开头的,有几个1,就代表该汉子由几个字节组成
            //英文不需要进行任何处理++
                i++;
                continue;
            }else{
                //如果是汉字,就需要判断几个字符表示一个汉字.如果最后的字符不是完整的汉字,则需要返回起始的位置.
                int begin = i;
                for(int j = 0;;j++){
                    if(((temp<<j&0x80)>>7&1)==1){
                        i++;
                        if(i>array.length){
                            return begin;
                        }
                    }else{break;}
                }
            }


        }
        return array.length;
    }
}
