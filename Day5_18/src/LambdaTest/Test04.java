package LambdaTest;

import java.util.Optional;
import java.util.function.Function;

public class Test04 {
    public static void main(String[] args) {
        Function<Integer,String[]> function=String[]::new;
       String[] strings=function.apply(3);
        for (String string : strings) {
            System.out.println(string);
        }
        String[] str=new String[3];
        str=null;
        System.out.println(str[1]);
        String s=new String();
        Optional optional=Optional.empty();



    }
}
