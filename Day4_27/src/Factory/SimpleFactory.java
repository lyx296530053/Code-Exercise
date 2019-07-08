package Factory;
interface  BuyComputer{
    void show();
}
class  LenovoComputer implements BuyComputer{

    @Override
    public void show() {
        System.out.println("这里是联想电脑");
    }
}
class  MacComputer implements BuyComputer{

    @Override
    public void show() {
        System.out.println("这里是苹果电脑");
    }
}
class ComputerShop {
    public static BuyComputer getComputer(String name) {
    BuyComputer buyComputer=null;
    if(name.equals("lenovo")){
        buyComputer=new LenovoComputer();
    }
    if(name.equals("mac")){
        buyComputer=new MacComputer();
    }
    return buyComputer;
    }
}
class Cilent{
    public void buComputer(BuyComputer buyComputer){
        buyComputer.show();
    }
}
public class SimpleFactory {
    public static void main(String[] args) {

    Cilent cilent=new Cilent();
    cilent.buComputer(ComputerShop.getComputer("mac"));
    }
}
