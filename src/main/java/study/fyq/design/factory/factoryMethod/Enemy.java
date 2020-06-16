package study.fyq.design.factory.factoryMethod;

/**
 * @author fengyongquan
 * @description
 * @date 2020/6/16
 */
public abstract class Enemy {

    /**所有敌人的坐标*/
    protected int x;
    protected int y;

    /**初始化坐标*/
    public Enemy(int x,int y){
        this.x = x;
        this.y= y;

    }

    /** 抽象方法，在地图上绘制*/
    public abstract void show();


}
