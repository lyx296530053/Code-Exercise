package cn.lyx.Stream;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test1 {
    @Test
    public void test() {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 5, 5, 6, 7);
        List<Integer> collect = integerStream.collect(Collectors.toList());
    }

}
