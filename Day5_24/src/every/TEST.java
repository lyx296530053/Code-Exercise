package every;

public class TEST {
    public static void main(String[] args) {
        String s=new String("hello");
        char[] b={'a','b','c'};
        change(s,b);
        System.out.println(s);
        System.out.println(b);
    }
   static void change(String a,char[] c){
        a=new String("qqqq");

    }
}
