package DynamicProxy;

class Orchard01 implements Apple{

    @Override
    public void show() {
        System.out.println("这是红富士");
    }

    @Override
    public void money() {
        System.out.println(111);
    }
}
class Proxy implements Apple{
    private Apple apple;

    public Proxy(Apple apple) {
        this.apple = apple;
    }

    @Override
    public void show() {
        System.out.println("来了老弟");
        apple.show();
        System.out.println("下次再来玩呀");
    }

    @Override
    public void money() {
        System.out.println(111);
    }
}
public class Test01 {
    public static void main(String[] args) {
    Proxy proxy=new Proxy(new Orchard01());
    proxy.show();
    }
}
