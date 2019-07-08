package StreamTest;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class Test03 {
    public static void main(String[] args) {
        BiConsumer<Integer,Integer> biConsumer=(o1,o2)-> System.out.println(o1+o2);
        biConsumer.accept(1,2);
        BiFunction<Integer,Integer,Integer> biFunction=(o1,o2)->o1+o2;
        System.out.println(biFunction.apply(1,2));
        BinaryOperator<Integer>binaryOperator =(o1,o2)->o1+o2;
        System.out.println(binaryOperator.apply(8,2));
    }
}
