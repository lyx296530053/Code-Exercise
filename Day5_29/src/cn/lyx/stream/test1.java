package cn.lyx.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class test1 {
    public static void main(String[] args) {
        Integer[] arr={1,2,3,4,5,6,6,7,7,9};
        int[] arr1={23,43,4,54,5,65,7,7};
        List<Integer> integers = Arrays.asList(arr);
        Stream<Integer> stream = integers.stream();
        Stream<Integer> stream1 = Arrays.stream(arr);
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6, 8);
        Stream.iterate(10,t->t+1).limit(10).forEach(System.out::println);
        Stream.generate(Math::random).limit(10).forEach(System.out::println);

    }
}
