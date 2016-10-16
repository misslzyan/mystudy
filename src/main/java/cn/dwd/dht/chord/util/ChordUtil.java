package cn.dwd.dht.chord.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * chord util
 * Created by xiaoyanzi on 16/10/16.
 */
public class ChordUtil {

    public static int shaDegist(String str) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
        byte[] bytes = messageDigest.digest(str.getBytes("UTF-8"));
        byte lastByte = bytes[bytes.length-1];
        int a = lastByte&0x1F;
        return a;
    }
}
