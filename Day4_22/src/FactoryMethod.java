
interface Computer1{
    void showComputer();
}
class Lenovo1 implements Computer1{
    @Override
    public void showComputer() {
        System.out.println("这是联想电脑");
    }
}
class Mac1 implements Computer1{
    @Override
    public void showComputer() {
        System.out.println("这是苹果电脑");
    }
}
interface ComputerFactory{
    Computer1 computer();
}
class LenovoFactory implements ComputerFactory{
    @Override
    public Computer1 computer() {
        return new Lenovo1();
    }
}
class MacFactory implements ComputerFactory{
    @Override
    public Computer1 computer() {
        return new Mac1();
    }
}
class Cilent1{
    public void buyComputer(Computer1 computer){
        computer.showComputer();
    }
}
public class FactoryMethod {
    public static void main(String[] args) {
        ComputerFactory computerFactory=new MacFactory();
    Cilent1 cilent1=new Cilent1();
    cilent1.buyComputer(computerFactory.computer());
    }
}
