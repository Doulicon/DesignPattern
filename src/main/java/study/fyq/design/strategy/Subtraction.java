package study.fyq.design.strategy;

/**
 * @author fengyongquan
 * @description 减法规范
 * @date 2020/6/24
 */
public class Subtraction implements Strategy {
    @Override
    public int calculate(int a, int b) {
        return a-b;
    }
}
