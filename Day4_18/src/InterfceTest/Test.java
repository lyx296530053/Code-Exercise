package InterfceTest;



interface  Person{
     static void show(){
        System.out.println("接口增强测试");
    }
     default void fun(){
        System.out.println("default测试");
    }
    void find();
}
class people implements Person{
    @Override
    public void find() {
        System.out.println("实现方法");
    }
}
public class Test {
    public static void main(String[] args){
    new people().find();
    new people().fun();
    Person.show();
    }
}
