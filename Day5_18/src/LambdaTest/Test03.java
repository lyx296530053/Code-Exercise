package LambdaTest;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class Test03 {
    public static void main(String[] args) {
        Consumer<String> consumer=(a)-> System.out.println(a);
        consumer.accept("beijing");
        Consumer<String> consumer01=System.out::println;
        consumer01.accept("xian");
        Supplier<String> supplier=()-> "woaini".toUpperCase();
        System.out.println(supplier.get());
        String str="hello";
        Supplier<String> supplier01=str::toUpperCase;
        System.out.println(supplier01.get());
    }
}
