package study.fyq.design.proxy.dynamic;

import java.lang.reflect.Proxy;

/**
 * @author fengyongquan
 * @description
 * @date 2020/6/16
 */
public class ProxyFactory {

    public static Object getProxy(Object tager){
        DynamicProxyHandler hander = new DynamicProxyHandler(tager);
        Object proxy = Proxy.newProxyInstance(tager.getClass().getClassLoader(),tager.getClass().getInterfaces(),hander);
        return proxy;

    }


}
