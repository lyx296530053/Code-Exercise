package Sort;

/**
 * Created by lyx on 2019/4/2.
 */
public class SortTest {
    public static void main(String[] args){
        int[] arr=new int[]{3,2,7,9,5,4,8,1,3,6};
        //Sort4_13.insertSort(arr);
        //Sort4_13.shellSort(arr);
        //Sort4_13.binarySort(arr);
        //Sort4_13.mergeSort(arr,0,9);
        //Sort4_13.quickSort(arr,0,9);
        Sort4_13.threeSign(arr,0,9);
        for (int i:arr
             ) {
            System.out.print(i+" ");
        }
    }
}
