import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
        List list=new ArrayList();
        Stream stream1 = list.stream();
        IntStream stream = Arrays.stream(new int[]{1, 1, 2, 2, 3, 4, 5});
        Stream<Integer> integerStream = Stream.of(2, 3, 1, 4, 7, 8);
        Stream generate = Stream.generate(() -> {
            return Math.random();
        });
        generate.limit(10).forEach(System.out::println);
        Stream<Integer> iterate = Stream.iterate(0, o1 -> o1 + 2);
        iterate.limit(10).forEach(System.out::println);
    }
}
