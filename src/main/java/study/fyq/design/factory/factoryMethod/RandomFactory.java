package study.fyq.design.factory.factoryMethod;

import java.util.Random;

/**
 * @author fengyongquan
 * @description 小兵随机生成
 * @date 2020/6/16
 */
public class RandomFactory implements Factory {

    private Random random = new Random();


    @Override
    public Enemy create(int screenWidth) {
        Enemy enemy = null;
        if(random.nextBoolean()){
            enemy = new Airplane(random.nextInt(screenWidth),0);
        }else {
            enemy = new Tank(random.nextInt(screenWidth),0);
        }
        return enemy;
    }
}
