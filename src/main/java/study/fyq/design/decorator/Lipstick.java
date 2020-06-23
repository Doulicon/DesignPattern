package study.fyq.design.decorator;

/**
 * @author fengyongquan
 * @description
 * @date 2020/6/23
 */
public class Lipstick extends Decorator {
    public Lipstick(Showable showable) {
        super(showable);
    }

    @Override
    public void show(){
        System.out.println("涂口红");
        showable.show();
    }
}
