import java.util.Arrays;
import java.util.stream.IntStream;

public class TestStream {
    public static void main(String[] args) {
        int[] arr={2,1,3,4};
        int x=1;
        int y=2;
        swap swap= (a, b, c) -> swaps(a, b, c);
        swap.accept(arr,x,y);
        System.out.println();
        IntStream stream = Arrays.stream(arr);
        stream.forEach(i1 -> System.out.print(i1));

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    static void swaps(int[] a,int b,int c){
        int temp=a[b];
        a[b]=a[c];
        a[c]=temp;
    }
    @FunctionalInterface
    interface swap{
        void accept(int[] arr,int low,int high);
    }
}
