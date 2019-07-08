package cn.lyx.StaticTest;
interface A1{
    static void get(){
        System.out.println("jingtai");
    }
    default void get(String a){
        System.out.println(a);
    }
    void get(String a,String b);
}
class B1 implements A1{

    @Override
    public void get(String a, String b) {
        System.out.println(a+b);
    }
}
public class Interface {
    public static void main(String[] args) {
        A1 a1=new B1();
        a1.get("12323");
        a1.get("1232","1323");
        A1.get();
    }
}
