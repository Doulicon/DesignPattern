package study.fyq.design.singleton;

/**
 * @author fengyongquan
 * @description 单例模式，懒汉式
 * 是否 Lazy 初始化：否
 * 是否多线程安全：是
 * 实现难度：易
 * 描述：这种方式比较常用，但容易产生垃圾对象。
 * 优点：没有加锁，执行效率会提高。
 * 缺点：类加载时就初始化，浪费内存。
 * 它基于 classloader 机制避免了多线程的同步问题，
 * 不过，instance 在类装载时就实例化，虽然导致类装载的原因有很多种，
 * 在单例模式中大多数都是调用 getInstance 方法，
 * 但是也不能确定有其他的方式（或者其他的静态方法）导致类装载，
 * 这时候初始化 instance 显然没有达到 lazy loading 的效果。
 * @date 2020/6/9
 */
public class Singleton2 {

    private static Singleton2 instance;

    private Singleton2(){System.out.println("创建懒汉式单例成功");};

    /**
     * 该代码还是存在性能上的问题，因为在整个方法上加了锁
     * @return
     */
    public static synchronized Singleton2 getInstance(){

        if(instance==null){
            instance = new Singleton2();
        }

        return instance;
    }

    /**
     * 改进，将同步方法改进为同步代码块
     * 但是该代码还是存在问题，当高并发时
     * 仍会有多个线程进入if代码块内
     * 进入后会排队依次执行 instance = new Singleton2(),
     * 从而导致线程不安全
     */
    public static Singleton2 getInstance2(){
        if(instance == null){
            synchronized (Singleton2.class){
                instance = new Singleton2();
            }
        }
        return instance;
    }

    /**
     * 简单的改进方法
     */
    public static Singleton2 getInstance3(){
        if(instance == null){
            synchronized (Singleton2.class){
                //再一次判断，防止同时进入的符合条件的经常进行等待，最后只能new 一个
                if(instance==null){
                    instance = new Singleton2();
                }
            }
        }
        return instance;
    }


}
