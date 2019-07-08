package StreamTest;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Test01 {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,6,6};
        IntStream stream = Arrays.stream(arr);
        stream.filter(a->a!=6).forEach(System.out::println);
        System.out.println("*********************");
        IntStream stream01 = Arrays.stream(arr);
        stream01.filter(a->a!=6).limit(3).forEach(System.out::println);
        System.out.println("*********************");
        IntStream stream03 = Arrays.stream(arr);
        stream03.filter(a->a!=6).limit(3).skip(1).forEach(System.out::println);
        System.out.println("*********************");
        IntStream stream02 = Arrays.stream(arr);
        stream02.distinct().forEach(System.out::println);
        System.out.println("*********************");
        IntStream stream04 = Arrays.stream(arr);
        stream04.map(a-> a+=3).forEach(System.out::println);
    }
}
