package study.fyq.design.decorator;

/**
 * @author fengyongquan
 * @description
 * @date 2020/6/23
 */
public class Decorator implements Showable {

    Showable showable;

    public Decorator(Showable showable){
        this.showable = showable;
    }


    @Override
    public void show() {
        showable.show();
    }
}
