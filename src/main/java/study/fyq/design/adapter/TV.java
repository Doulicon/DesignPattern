package study.fyq.design.adapter;

/**
 * @author fengyongquan
 * @description 电视接通
 * @date 2020/6/22
 */
public class TV implements DualPin  {

    @Override
    public void electrify(int l, int n) {
        System.out.println("火线通电：" + l);
        System.out.println("零线通电：" + n);
        System.out.println("地线已经废弃");
        System.out.println("通知其他方法可以工作");
    }
}
