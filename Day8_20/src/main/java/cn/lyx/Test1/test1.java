package cn.lyx.Test1;

import java.util.*;
import java.util.concurrent.RecursiveTask;

abstract class a implements Comparable {
    abstract public int test();

}

abstract class b extends a {

    abstract public int test1();

}

class ForkJoinExample extends RecursiveTask<Integer> {

    @Override
    protected Integer compute() {
        return null;
    }
}

class C {
    public static void printf() {
        System.out.println(111);
    }
}


        public class test1 {
            public static void main(String[] args) {
                C c = null;
                c.printf();

                HashMap<String, Integer> hashMap = new HashMap();
                hashMap.put("a", 1);
                hashMap.put("b", 2);
                hashMap.put("c", 3);
                hashMap.put("d", 4);
                Set<String> strings = hashMap.keySet();
                for (String string : strings) {
                    Integer integer = hashMap.get(string);
                    System.out.print(integer + " ");
                }
                System.out.println();
                Collection<Integer> values = hashMap.values();
                for (Integer value : values) {
                    System.out.print(value + " ");
                }
                System.out.println();
                Set<Map.Entry<String, Integer>> entries = hashMap.entrySet();
                for (Map.Entry<String, Integer> entry : entries) {
                    System.out.println(entry.getKey() + entry.getValue());
                }
            }
        }
