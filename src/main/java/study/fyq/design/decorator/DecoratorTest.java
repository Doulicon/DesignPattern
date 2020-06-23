package study.fyq.design.decorator;

/**
 * @author fengyongquan
 * @description
 * @date 2020/6/23
 */
public class DecoratorTest {

    public static void main(String[] args) {

        Showable llGirl = new FoundationMakeUp(new Lipstick(new Girl()));
        llGirl.show();

    }
}
