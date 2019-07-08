package LambdaTest;

@FunctionalInterface
interface Swap{
    void swap(int low,int high,Integer[] arr);
}
public class Test01 {
    public static void main(String[] args) {

      Integer[] arr={3,6,1,7,9,3,5};
      Swap swap=(o1,o2,o3)->{
          int temp=o3[o1];
          o3[o1]=o3[o2];
          o3[o2]=temp;
      };
      swap.swap(0,1,arr);
        for (Integer integer : arr) {
            System.out.print(integer);
        }
    }
}
