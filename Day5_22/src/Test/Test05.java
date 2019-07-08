package Test;

import java.util.function.Function;
@FunctionalInterface//
interface A5{
   int show();//supplier
}
@FunctionalInterface
interface B5{
    void show(int a);//consumer
}
interface C5{
    int show(String s);//function
}
public class Test05 {
    public static void main(String[] args) {
        Function<Integer,String[]> function= o1->new String[o1];
        String[] apply = function.apply(5);
        Function<Integer,String[]> function1= String[]::new;
        A5 a5=()-> {
            int a=82;
            return a;
        };

    }
}
