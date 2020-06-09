package study.fyq.design.singleton;

/**
 * @author fengyongquan
 * @description
 * @date 2020/6/8
 */
public class SingletonTest {

        public static void main(String[] args) {

            //避免魔法值
            int count = 100;

            //不合法的构造函数
            //编译时错误：构造函数 SingleObject() 是不可见的
            //SingleObject object = new SingleObject();
            //获取唯一可用的对象
            //Singleton object = Singleton.getInstance();

            //传统写法
//            Runnable task = new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println(Singleton2.getInstance3().hashCode());
//                }
//            };
//
//            for(int i=0;i<count;i++){
//                new Thread(task).start();
//            }

            for(int i=0;i<count;i++){
                //lambda表达式
                new Thread(() -> System.out.println(Singleton2.getInstance().hashCode())).start();
            }

        }

}
