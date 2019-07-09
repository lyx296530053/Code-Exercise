package BaseClass;

import java.util.Arrays;

public class Testcode {
    public static void main(String[] args){
        int[] arr1 = new int[]{1,2,3,4};
        int[] arr2 = new int[]{1,2,3,4};
        boolean isEquals = Arrays.equals(arr1, arr2);
        System.out.println(isEquals);
    }
}
