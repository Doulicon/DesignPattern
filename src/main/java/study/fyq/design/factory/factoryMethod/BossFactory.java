package study.fyq.design.factory.factoryMethod;

/**
 * @author fengyongquan
 * @description
 * @date 2020/6/16
 */
public class BossFactory implements Factory {
    @Override
    public Enemy create(int screenWidth) {
        return new Boss(screenWidth/2,0);
    }
}
