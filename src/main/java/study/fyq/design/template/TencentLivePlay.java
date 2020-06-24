package study.fyq.design.template;

/**
 * @author fengyongquan
 * @description 腾讯直播
 * @date 2020/6/24
 */
public class TencentLivePlay extends LivePlay {
    @Override
    public void openRoom() {
        System.out.println("腾讯打开房间");
    }

    @Override
    public void startAudioAndVideoStream() {
        System.out.println("腾讯打开音视频流");
    }

    @Override
    public void stopAudioAndVideoStream() {
        System.out.println("腾讯关闭音视频流");
    }

    @Override
    public void closeRoom() {
        System.out.println("腾讯关闭房间");
    }

    //根据需要复写，不一定要
    @Override
    public void pushVideoStream(){
        super.pushVideoStream();
        System.out.println("腾讯进行旁路推流");
    }



}
