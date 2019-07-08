package cn.lyx.everday;

public class Test1 {
    public static void main(String[] args) {

    }
    public int[] exchangeAB(int[] AB) {
       int a=AB[0];
       int b=AB[1];
       a=a+b;
       b=a-b;
       a=a-b;
       AB[0]=a;
       AB[1]=b;
       return AB;
    }
}
