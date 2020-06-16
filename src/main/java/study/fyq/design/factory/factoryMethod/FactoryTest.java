package study.fyq.design.factory.factoryMethod;

/**
 * @author fengyongquan
 * @description
 * @date 2020/6/16
 */
public class FactoryTest {
    public static void main(String[] args){
        int screenWidth = 100;
        System.out.println("游戏开始");

        //创建随机生成的小兵
        Factory factory = new RandomFactory();
        for(int i=0;i<10;i++){
            factory.create(screenWidth).show();
        }
        //创建boss
        factory = new BossFactory();
        factory.create(screenWidth).show();


    }
}
