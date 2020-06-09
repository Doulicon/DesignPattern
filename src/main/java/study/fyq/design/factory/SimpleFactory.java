package study.fyq.design.factory;

/**
 * @author fengyongquan
 * @description 简单工厂(很好理解)
 * 由一个工厂类根据传入的参数，动态决定应该创建哪一个产品类。
 * 该工厂没有遵循此原则，若新增新的水果，那么工厂类也要改
 * @date 2020/6/9
 */
public class SimpleFactory {

    public static Fruit getInstance(String className){
        Fruit fruit = null;
        if(className.equals("apple")){
            fruit = new Apple();
        }
        if(className.equals("orange")){
            fruit = new Orange();
        }
        return fruit;
    }

}

class SimpleFactoryDemo{
    public static void main(String[] args){
        Fruit fruit = SimpleFactory.getInstance("apple");
        fruit.product();
    }
}
