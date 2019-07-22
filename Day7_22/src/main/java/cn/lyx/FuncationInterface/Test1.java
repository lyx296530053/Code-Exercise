package cn.lyx.FuncationInterface;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.Date;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Test1 {
    public int swap(int a, int b, ICompare<Integer> o2) {
        return o2.compare(a, b);
    }

    @Test
    public void test1() {
        int swap = swap(10, 20, (a, b) -> a.compareTo(b));
    }

    /**
     * 对象调用方法
     */
    public void test2() {
        Consumer<String> consumer = s -> System.out.println(s);//1
        PrintStream out = System.out;
        Consumer<String> consumer1 = s -> out.println(s);//2
        Consumer<String> consumer2 = System.out::println;//3
    }

    @Test
    /**
     * 类调用静态方法
     */
    public void test3() {
        Function<Integer, String> function = i -> String.valueOf(i);
        Function<Integer, String> function1=String::valueOf;
    }

    /**
     * 类调用方法
     * 当函数式接口方法的第一个参数是需要引用方法的调用者，并且第二
     * 个参数是需要引用方法的参数(或无参数)时：ClassName::methodName
     */
    public void test4(){
        BiConsumer<Integer,Integer> consumer=(a,b)->a.compareTo(b);
        BiConsumer<Integer,Integer> consumer1=Integer::compareTo;
    }

    /**
     * 构造器引用
     */
    public void test5(){
        Supplier<Date> supplier=()->new Date();
        Supplier<Date> supplier1=Date::new;
    }

    /**
     * 数组引用
     */
    public void test6(){
       Function<Integer,String[]> function=n->new String[n];
        Function<Integer,String[]> function1=String[]::new;
    }
}
