package cn.lyx.Day8_27;

public class Test1 {
    protected  int anInt = 5;
    protected void test1(){
        System.out.println(2);
    }

    public static void main(String[] args) {
         b b
                 =new b();
         b.test();
    }
}
class b extends Test1{
    public void test(){
        System.out.println(anInt);
        test1();
    }
}

