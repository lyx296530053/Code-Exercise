package cn.lyx.Factory;
interface Computer{
    void show();
}
class Lenovo implements Computer{

    @Override
    public void show() {
        System.out.println("lenovo");
    }
}
class Apple implements Computer{

    @Override
    public void show() {
        System.out.println("Apple");
    }
}
class Factory {

    public static Computer getComputer(String string){
         Computer computer=null;
         if("lenovo".equals(string)){
             computer=new Lenovo();
         }
         if("apple".equals(string)){
             computer=new Apple();
         }
         return computer;
    }
}
public class SimpleFactory {
    public static void main(String[] args) {
        Computer lenovo = Factory.getComputer("lenovo");
        lenovo.show();
    }
}
