package Factory;
interface BuyComputer1{
    void show();
}
class Lenovo implements BuyComputer1{

    @Override
    public void show() {
        System.out.println("联想电脑");
    }
}
class Mac implements BuyComputer1{

    @Override
    public void show() {
        System.out.println("苹果电脑");
    }
}
interface  ComputerFactory{
    BuyComputer1 buy();
}
class LenovoFactory implements ComputerFactory{

    @Override
    public BuyComputer1 buy() {
        return new Lenovo();
    }
}
class MacFactory implements ComputerFactory{

    @Override
    public BuyComputer1 buy() {
        return new Mac();
    }
}
class  Cilent1{
    public void buyComputer(BuyComputer1 buyComputer1){
        buyComputer1.show();
    }
}
public class FactoryMethod {
    public static void main(String[] args) {
        ComputerFactory computerFactory=new MacFactory();
    Cilent1 cilent1=new Cilent1();
    cilent1.buyComputer(computerFactory.buy());
    }
}
