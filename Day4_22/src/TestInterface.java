interface Iperson{
    public default void shows(){
        System.out.println("我是普通方法");
    }
    public static void show(){
        System.out.println("我是接口");
    }
}
class people implements Iperson{

}
public class TestInterface {
    public static void main(String[] args) {
        Iperson.show();
        new people().shows();
    }
}
