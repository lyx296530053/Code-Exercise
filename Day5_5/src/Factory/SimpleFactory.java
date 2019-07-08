package Factory;

import java.util.Scanner;

interface Computer{
    void show();
}
class Lenovo implements Computer{

    @Override
    public void show() {
        System.out.println("这是联想电脑");
    }
}
class Mac implements Computer{

    @Override
    public void show() {
        System.out.println("这是苹果电脑");
    }
}
class ComputerFactory{
    public static Computer getComputer(String name){
        Computer computer=null;
        if(name.equals("联想")){
            computer=new Lenovo();
        }
        if(name.equals("苹果")){
            computer=new Mac();
        }
        return computer;
    }
}
class Cilent{
    void buyComputer(Computer computer){
        computer.show();
    }
}
public class SimpleFactory {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String name=scanner.nextLine();
        Cilent c=new Cilent();
        c.buyComputer(ComputerFactory.getComputer(name));
    }
}
