package cn.lyx.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class test2 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 99,8, 4, 5, 6, 6, 6, 7, 10};
        IntStream stream = Arrays.stream(arr);
        stream.filter(o -> o != 2).forEach(System.out::println);
        IntStream stream1 = Arrays.stream(arr);
        stream1.distinct().forEach(System.out::println);
        IntStream stream2 = Arrays.stream(arr);
        stream2.skip(2).forEach(System.out::println);
        IntStream stream3 = Arrays.stream(arr);
        stream3.map(o->o+2).forEach(System.out::println);
        IntStream stream4 = Arrays.stream(arr);
//        stream4.sorted((o1,o2)->Integer.compare(o1,o2)).forEach(System.out::println);
        boolean b = stream4.allMatch(o -> o > 4);
        System.out.println(b);
        IntStream stream5 = Arrays.stream(arr);
        boolean b1 = stream5.noneMatch(o -> o > 5);
        System.out.println(b1);
        IntStream stream6 = Arrays.stream(arr);
        boolean b2 = stream6.anyMatch(o -> o > 4);
        System.out.println(b2);
        IntStream stream7 = Arrays.stream(arr);
        long count = stream7.count();
        System.out.println(count);
        ArrayList<Integer> list=new ArrayList<Integer>();
        Stream stream8 = list.parallelStream();
        Collections.addAll(list,1,2,3,4,6,7,8);
        list.forEach(System.out::println);
        Stream<Integer> stream9 = list.stream();
        stream9.reduce(0,Integer::sum);
        Stream<Integer> stream10 = list.stream();
        Set<Integer> collect = stream10.sorted(Integer::compareTo).collect(Collectors.toSet());
        collect.forEach(System.out::println);

    }
}
