package study.fyq.design.proxy.staticProxy;

/**
 * @author fengyongquan
 * @description
 * @date 2020/6/16
 */
public class BuyCarImpl implements BuyCar {
    @Override
    public void buyCar() {
        System.out.println("准备钱财，准备资料");
    }
}
