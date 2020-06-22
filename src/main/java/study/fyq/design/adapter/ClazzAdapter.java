package study.fyq.design.adapter;

/**
 * @author fengyongquan
 * @description 类适配器，专用
 * @date 2020/6/22
 */
public class ClazzAdapter extends TV implements TriplePin{

    @Override
    public void electrify(int l, int n, int e) {
        super.electrify(l,n);
    }
}
