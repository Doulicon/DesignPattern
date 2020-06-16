package study.fyq.design.proxy.staticProxy;

/**
 * @author fengyongquan
 * @description
 * @date 2020/6/16
 */
public class BuyCarProxy implements BuyCar {

    private BuyCar buyCar;

    public BuyCarProxy(final BuyCar buyCar) {
        this.buyCar = buyCar;
    }

    @Override
    public void buyCar() {

        System.out.println("买车前准备");
        buyCar.buyCar();
        System.out.println("买车后服务");

    }
}
