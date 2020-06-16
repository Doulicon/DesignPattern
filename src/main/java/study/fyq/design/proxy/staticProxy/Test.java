package study.fyq.design.proxy.staticProxy;

/**
 * @author fengyongquan
 * @description
 * @date 2020/6/16
 */
public class Test {
    public static void main(String[] args) {
        BuyCar buyCar = new BuyCarImpl();
        BuyCarProxy buyCarProxy = new BuyCarProxy(buyCar);
        buyCarProxy.buyCar();
    }


}
