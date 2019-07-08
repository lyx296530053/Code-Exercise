package Array;
class Order{
    int orderId;
}
public class Test {
    public static void main(String[] args) {
    show(123,"hello","adsd","dsff");
        int m = 10;
        int n = m;
        System.out.println("m = " + m + ", n = " + n);
        n = 20;
        System.out.println("m = " + m + ", n = " + n);

        Order o1 = new Order();
        o1.orderId = 1001;
        Order o2 = o1;//赋值以后，o1和o2的地址值相同，都指向了堆空间中同一个对象实体。
        System.out.println("o1.orderId = " + o1.orderId + ",o2.orderId = " +o2.orderId);
        o2.orderId = 1002;
        System.out.println("o1.orderId = " + o1.orderId + ",o2.orderId = " +o2.orderId);
    }
//    public static void show(int a,String[] arr){};
    public static void show(int a,String...s){
        System.out.println(a);
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }
    }
}
