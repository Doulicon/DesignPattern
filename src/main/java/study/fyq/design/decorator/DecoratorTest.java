package study.fyq.design.decorator;

/**
 * @author fengyongquan
 * @description
 * @date 2020/6/23
 */
public class DecoratorTest {

    public static void main(String[] args) {

        //可以通过注入一直套娃
        Showable suyanGirl = new Girl();
        Showable llGirl = new FoundationMakeUp(new Lipstick(new Girl()));
        suyanGirl.show();
        System.out.println("====");
        llGirl.show();

    }
}
