package cn.dwd.thread;

import net.jcip.annotations.ThreadSafe;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.math.BigInteger;

/**
 * 描述:构建一个线程安全的类,对数值进行缓存.
 * Created by xiaoyanzi on 16/3/14.
 */
@ThreadSafe
public class VolatileCacheFactorizer {
    private volatile OneValueCache cache = new OneValueCache(null,null);

    public void service(ServletRequest request,ServletResponse response ){
        String i = request.getParameter("i");
        BigInteger bigInteger = new BigInteger(i);
        BigInteger[] factors = cache.getFactors(bigInteger);
        if(factors==null){
            factors = factor(bigInteger);
            cache = new OneValueCache(bigInteger,factors);
        }
        System.out.println(factors);

    }

    public BigInteger[] factor(BigInteger bigInteger){
        return new BigInteger[]{bigInteger};
    }
}
