package cn.dwd.thread;

/**
 * 描述:不正确的发布对象
 * Created by xiaoyanzi on 16/3/14.
 */
public class UnSafePublish {
    //这种发布时不正确的,存在可见性问题,其他线程看到的hold将处于不一致的状态.
    public UnSafePublish hold;

    public void initialize(){
        hold = new UnSafePublish();
    }
}
