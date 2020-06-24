package study.fyq.design.template;

/**
 * @author fengyongquan
 * @description
 * @date 2020/6/24
 */
public class TemplateTest {
    public static void main(String[] args) {

        //根据用户的选择来决定使用哪一家的SDK
        LivePlay livePlay = new TencentLivePlay();
        livePlay.seeLivePlay();

        livePlay = new JinShanLivePlay();
        livePlay.seeLivePlay();


    }
}
