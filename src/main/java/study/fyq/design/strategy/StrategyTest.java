package study.fyq.design.strategy;

/**
 * @author fengyongquan
 * @description
 * @date 2020/6/24
 */
public class StrategyTest {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Strategy add = new Addition();
        calculator.setStrategy(add);
        int a = calculator.getResult(1,2);
        calculator.setStrategy(new Subtraction());
        int b = calculator.getResult(2,1);

        System.out.println(a+"--"+b);
    }
}
