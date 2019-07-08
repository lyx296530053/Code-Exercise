package cn.lyx.Factory;
interface Computer1{
    void show();
}
class Lenovo1 implements Computer1{

    @Override
    public void show() {
        System.out.println("lenovo");
    }
}
class Apple1 implements Computer1{

    @Override
    public void show() {
        System.out.println("Apple");
    }
}
interface ComputerFactory{
    Computer1 getComputer();
}
class LenovoFactory implements ComputerFactory{

    @Override
    public Computer1 getComputer() {
        return new Lenovo1();
    }
}
class AppleFactory implements ComputerFactory{

    @Override
    public Computer1 getComputer() {
        return new Apple1();
    }
}
public class FactoryMethod {
    public static void main(String[] args) {
        ComputerFactory computerFactory=new LenovoFactory();
        Computer1 computer = computerFactory.getComputer();
        computer.show();
    }
}
