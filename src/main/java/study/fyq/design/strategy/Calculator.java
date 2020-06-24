package study.fyq.design.strategy;

/**
 * @author fengyongquan
 * @description
 * @date 2020/6/24
 */
public class Calculator {
    private Strategy strategy;

    public void setStrategy(Strategy strategy){
        this.strategy = strategy;
    }

    public int getResult(int a,int b){
        return this.strategy.calculate(a,b);
    }


}
