package Every;
class T1{
    public T1(String a){
        System.out.println("a");
    }
    public static void show(){}
    public void show1(){
        T1.show();
    }

}

public class Test01 extends T1{
    public Test01(String a) {
        super(a);
    }
    public void shows(){
        T1.show();
        super.show1();
    }

    public static void main(String[] args) {
new Test01("s");
    }
}
