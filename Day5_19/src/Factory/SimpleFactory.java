package Factory;
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
class Factory{
    public static Computer getInstance(String name){
        Computer computer=null;
        if(name.equals("lianxiang")){
             computer=new Lenovo();
        }
        if(name.equals("mac")){
            computer=new Mac();
        }
        return computer;
    }
}
class Cilent{
    public void buy(Computer computer){
        computer.show();
    }
}
public class SimpleFactory {
    public static void main(String[] args) {
    new Cilent().buy(Factory.getInstance("lianxiang"));
    }
}
