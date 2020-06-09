package study.fyq.design.singleton;

/**
 * @author fengyongquan
 * @description 单例模式：保证一个只有一个实例，并提供一个只有他的全局访问点
 * @date 2020/6/8
 */
public class Singleton1 {
    /**
     * 饿汉式
     * static保证他在内存中永存，与类同在，而不是对象，final保证他不能修改
     */
    private static final Singleton1 instance = new Singleton1();

    private Singleton1(){};

    public static Singleton1 getInstance(){
        return  instance;
    }

    public void getMessage(){
        System.out.println("成功创建单例对象");
    }

}
