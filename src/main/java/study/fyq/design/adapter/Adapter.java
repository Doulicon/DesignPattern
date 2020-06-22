package study.fyq.design.adapter;

/**
 * @author fengyongquan
 * @description 适配器接三头接口，连接三头和双头的桥梁
 * @date 2020/6/22
 */
public class Adapter implements TriplePin{

    //双头设备
    private DualPin dualPinDevice;

    //接入双头设备
    public Adapter(DualPin dualPinDevice){
        this.dualPinDevice = dualPinDevice;
    }

    @Override
    public void electrify(int l, int n, int e) {
        //只调用双头的设备
        System.out.println("转换成双头");
        dualPinDevice.electrify(l,n);
    }
}
