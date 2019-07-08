package LambdaTest;

import java.util.function.Consumer;
import java.util.function.Supplier;

@FunctionalInterface
interface MyFunction {
    void show();
}

public class Test {
    public static void main(String[] args) {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("我爱北京天安门");
            }
        };
        r1.run();
        new Thread(() -> {
            System.out.println("woaibeijingtiananmen");
        }).start();
        String str="woaini";
        Thread thread=new Thread(System.out::println);
        thread.run();
//        Comparator<Integer> comparator = (o1, o2) -> Integer.compare(o1, o2);
//        System.out.println(comparator.compare(1, 2));
//        Comparator<Integer> comparator1 = Integer::compare;
//        int[] arr = {1, 2, 3};
//        MyFunction function = () -> System.out.println("hello");
//        function.show();
//        Predicate<String> predicate = o1 -> o1.length() > 5;
//        System.out.println(predicate.test("lydaujdk"));
//        Test.show(18, a -> System.out.println(a));
//        System.out.println(Test.show(() -> {
//            int a = 10;
//            int b = 20;
//            return a + b;
//        }));


    }

    public static Integer show(Supplier<Integer> supplier) {
        return supplier.get();
    }

    public static void show(Integer a, Consumer<Integer> consumer) {
        consumer.accept(a);
    }
}
