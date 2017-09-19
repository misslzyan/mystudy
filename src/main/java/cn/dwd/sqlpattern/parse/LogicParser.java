package cn.dwd.sqlpattern.parse;

/**
 * 描述：逻辑解析器
 * author: bjduanweidong
 * date: 2016/10/19
 */
public class LogicParser implements Parser<LogicTree> {

    /*逻辑树*/
    private LogicTree logicTree;

    private String param;

    @Override
    public void parse() throws Exception {
        //把逻辑表达式，构造成逻辑树
        logicTree = parseLogicTree(param,0,param.length());
    }

    /**
     * 转换成逻辑树
     * @param param
     * @return
     */
    private LogicTree parseLogicTree(String param , int begin , int end) {
        return null;
    }

    @Override
    public void setParam(String str) {
        this.param = str;
    }

    @Override
    public String getParam() {
        return this.param;
    }

    @Override
    public LogicTree getResult() {
        return this.logicTree;
    }


}
