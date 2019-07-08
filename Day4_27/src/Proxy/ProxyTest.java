package Proxy;
interface Icloth{
    void productClose();
}
class RealProduct implements Icloth{

    @Override
    public void productClose() {
        System.out.println("生产阿迪达斯衣服");
    }
}
class ClothFactory implements Icloth{
    private Icloth icloth;

    public ClothFactory(Icloth icloth) {
        this.icloth = icloth;
    }

    @Override
    public void productClose() {
        System.out.println("生产前准备");
        icloth.productClose();
        System.out.println("生产完毕");
    }
}
public class ProxyTest {
    public static void main(String[] args) {
        Icloth icloth=new RealProduct();
        Icloth icloth1=new ClothFactory(icloth);
        icloth1.productClose();
    }
}
