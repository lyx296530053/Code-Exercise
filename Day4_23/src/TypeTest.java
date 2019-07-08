import java.util.Arrays;

class Person{

     int  show(int...a){
        return a.length;
    }
    //int show(int[] a){};
    int show(String...a){
         return 0;
    }
}
public class TypeTest {
    static int a;

    public static void main(String[] args) {
        //int a;
        byte b = (byte) 200;
        float f = 3.4f;
        System.out.println(a);

        int[] arr1 = new int[]{2, 1, 3, 4};
        Arrays.fill(arr1, 10);
        System.out.println(Arrays.toString(arr1));
        System.out.println(new Person().show(1, 2, 3, 5, 6, 7, 4, 3, 2, 2));
        int[] original = new int[]{1, 3, 5, 7, 9};
        int[] result = Arrays.copyOf(original, 10);
        System.arraycopy(original,0,result,5,5);
        for (int temp : result) {
            System.out.print(temp);
        }
    }
}
