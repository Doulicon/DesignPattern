package study.fyq.design.factory.simpleFactory;

import java.util.Properties;

/**
 * @author fengyongquan
 * @description 对简单工厂模式的改进，
 * 利用配置文件来配置类名，从而生成所需的商品，类似IoC
 * @date 2020/6/9
 */
public class SimpleFactoryPlus {

    public static Fruit getInstance(String className){
        Fruit fruit = null;
        try {
            fruit = (Fruit) Class.forName(className).newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
        return fruit;
    }

}

 class FactoryTest{
     public static void main(String[] args){
         //TODO 获取配置文件的值
         Properties pro = new Properties();

         Fruit fruit = SimpleFactoryPlus.getInstance(pro.getProperty("apple"));
         fruit.product();
        }
}
