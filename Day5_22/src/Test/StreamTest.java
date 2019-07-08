package Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
        List list = new ArrayList();
        Stream stream = list.stream();
        int[] arr=new int[5];
        IntStream stream1 = Arrays.stream(arr);
        Stream generate = Stream.generate(()->{
            return Math.random()*10;
        });
        generate.limit(10).forEach(System.out::println);
        Stream<Integer> iterate = Stream.iterate(10, o1 -> o1 + 2);
        iterate.limit(10).forEach(System.out::println);
        Collections.addAll(list,1,2,3,4,5,6,6,6,7,8,8);
        Stream stream2 = list.stream();
        stream2.distinct().forEach(System.out::println);
        System.out.println("******************************************");
        Stream stream3 = list.stream();
        stream3.skip(3).forEach(System.out::println);
        Stream stream4 = list.stream();
    }
}
