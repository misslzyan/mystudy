package cn.dwd.sqlpattern.parse;

/**
 * 描述：解析器
 * author: bjduanweidong
 * date: 2016/10/19
 */
public interface Parser<T> {

    void parse() throws Exception;

    void setParam(String str);

    String getParam();

    T getResult();
}
