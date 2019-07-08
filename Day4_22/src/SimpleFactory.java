import java.util.Scanner;

interface Computer{
     void showComputer();
}
class LenovoComputer implements Computer{

    @Override
    public void showComputer() {
        System.out.println("这是联想电脑");
    }
}
class MacComputer implements Computer{

    @Override
    public void showComputer() {
        System.out.println("这是苹果电脑");
    }
}
class Factory{
    public static Computer getComputer(String name){
         Computer computer=null;
        if(name.equals("lenovo")){
            computer=new LenovoComputer();
        }
        if (name.equals("Mac")){
            computer=new MacComputer();
        }
        return computer;
    }
}
class  Cilent{
    public void buyComputer(Computer computer){
        computer.showComputer();
    }
}
public class SimpleFactory {
    public static void main(String[] args) {
    Cilent cilent=new Cilent();
        Scanner scanner=new Scanner(System.in);
        String name=scanner.nextLine();
        cilent.buyComputer(Factory.getComputer(name));
    }
}
