package study.fyq.design.decorator;

/**
 * @author fengyongquan
 * @description
 * @date 2020/6/23
 */
public class FoundationMakeUp extends Decorator {

    public FoundationMakeUp(Showable showable) {
        super(showable);
    }

    @Override
    public void show(){
        System.out.println("打粉底");
        showable.show();
    }


}
