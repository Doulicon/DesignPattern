package study.fyq.design.factory.factoryMethod;

/**
 * @author fengyongquan
 * @description
 * @date 2020/6/16
 */
public class Airplane extends Enemy {
    /**
     * 初始化坐标
     *
     * @param x
     * @param y
     */
    public Airplane(int x, int y) {
        super(x, y);
    }

    /**
     * 抽象方法，在地图上绘制
     */
    @Override
    public void show() {
        System.out.println("飞机出现坐标：" + x + "," + y);
        System.out.println("飞机向玩家发起攻击……");
    }

}
