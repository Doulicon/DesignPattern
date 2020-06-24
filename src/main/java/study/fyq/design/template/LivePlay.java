package study.fyq.design.template;

/**
 * @author fengyongquan
 * @description
 * @date 2020/6/24
 */
public abstract class LivePlay {



    //模板方法，将不变的行为(一般是步骤)总结出来。（子类不要重写这个方法）
    public final void seeLivePlay() {
        login();
        openRoom();
        startAudioAndVideoStream();
        pushVideoStream();
        stopAudioAndVideoStream();
        closeRoom();
    }

    //实体方法，这个方法实现通用的业务逻辑
    private void login() {
        System.out.println("用户登录");
    }

    /*抽象方法*/
    //打开房间
    public abstract void openRoom();
    //打开音视频流
    public abstract void startAudioAndVideoStream();
    //关闭音视频流
    public abstract void stopAudioAndVideoStream();
    //关闭房间
    public abstract void closeRoom();

    /*钩子方法，可以被需要的子类overwrite
    * 也可以不重写，和抽象方法不同，不需要必须重写
    * */
    public void pushVideoStream() {
    }

}
