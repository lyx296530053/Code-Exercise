package cn.lyx.Lambda;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

public class Test1 {
    /**
     * 无参无返回值
     * 当方法体只有一行时大括号可以省略
     * 当这一句为返回方法时return可以省略
     */
    @Test
    public void test1() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        };
        Runnable runnable1 = () -> System.out.println("hello");
    }

    /**
     * 有一个参数无返回值
     * 参数类型可以省略
     */
    @Test
    public void test2() {
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("hello");
            }
        };
        Consumer<String> consumer1 = s -> System.out.println(s);
    }

    /**
     * 有2个及以上参数无返回值
     * 参数外的括号不能省略
     */
    @Test
    public void test3() {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        Comparator<Integer> comparator1 = (o1, o2) -> o1.compareTo(o2);
    }
}
