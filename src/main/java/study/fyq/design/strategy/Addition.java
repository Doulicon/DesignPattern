package study.fyq.design.strategy;

/**
 * @author fengyongquan
 * @description 根据规范自定义算法
 * @date 2020/6/24
 */
public class Addition implements Strategy {
    @Override
    public int calculate(int a, int b) {
        return a+b;
    }
}
