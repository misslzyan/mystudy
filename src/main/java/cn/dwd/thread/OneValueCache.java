package cn.dwd.thread;

import net.jcip.annotations.Immutable;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * 描述:缓存两个数值的不可变容器类
 * Created by xiaoyanzi on 16/3/14.
 */
@Immutable
public class OneValueCache {
    private final BigInteger lastNumber;

    private final BigInteger[] lastFactors;

    public OneValueCache(BigInteger i,BigInteger[] factors){
        lastNumber = i;
        lastFactors = Arrays.copyOf(factors,factors.length);

    }

    public BigInteger[] getFactors(BigInteger i){
        if(i==null||!lastNumber.equals(i)){
            return null;
        }
        return Arrays.copyOf(lastFactors,lastFactors.length);
    }
}
