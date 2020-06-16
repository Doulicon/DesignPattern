package study.fyq.design.proxy.dynamic;

import study.fyq.design.proxy.staticProxy.BuyCar;
import study.fyq.design.proxy.staticProxy.BuyCarImpl;

/**
 * @author fengyongquan
 * @description 代理对象不需要实现接口,但是目标对象一定要实现接口,
 * 否则不能使用动态代理，因此这也算是这种方式的缺陷。
 * @date 2020/6/16
 */
public class Test {

    public static void main(String[] args) {
        BuyCar buyCar = new BuyCarImpl();
        BuyCar proxyBuyCar = (BuyCar)ProxyFactory.getProxy(buyCar);
        proxyBuyCar.buyCar();

    }

}
