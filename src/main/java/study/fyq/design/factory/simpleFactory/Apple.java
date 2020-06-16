package study.fyq.design.factory.simpleFactory;

/**
 * @author fengyongquan
 * @description
 * @date 2020/6/9
 */
public class Apple implements Fruit{
    @Override
    public void product() {
        System.out.println("生成一个苹果");
    }
}
