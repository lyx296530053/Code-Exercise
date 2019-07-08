package StreamAPITest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        List<String> list=new ArrayList();
        list.add("abc");
        list.add("qqq");
        list.add("ddd");
        list.add("eee");
        list.add("fff");
        list.add("ggg");
        Stream<String> stream = list.stream();
        int[] temp=new int[]{1,5,3,7,2,5};
        IntStream stream1 = Arrays.stream(temp);
        Stream<Integer> integerStream = Stream.of(54, 23, 13, 44, 77, 44);
        //stream.limit(3).forEach(System.out::print);
        //stream.map(n->n.toUpperCase()).forEach(System.out::println);
    }
}
