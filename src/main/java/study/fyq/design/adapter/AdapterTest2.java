package study.fyq.design.adapter;

/**
 * @author fengyongquan
 * @description
 * @date 2020/6/22
 */
public class AdapterTest2 {

    public static void main(String[] args) {
        //多态
        DualPin dualPin = new TV();
        Adapter adapter = new Adapter(dualPin);
        adapter.electrify(1,1,0);
    }



}
