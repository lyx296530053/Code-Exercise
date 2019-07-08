package LambdaTest;

import java.util.function.BiFunction;

public class Test02 {
    public static void main(String[] args) {
        Integer[] arr={1,2,3,4,5};
        Test02.show(0,1,arr,(a,b)->{
           int temp=arr[a];
           arr[a]=arr[b];
           arr[b]=temp;
           return null;
        });
        for (Integer integer : arr) {
            System.out.print(integer);
        }
    }
    public static void show(Integer a, Integer b, Integer[] arr, BiFunction<Integer ,Integer ,Integer[]> biFunction){
       biFunction.apply(a,b);
    }
}
