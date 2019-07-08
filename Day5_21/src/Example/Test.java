package Example;

public class Test {
    public static void main(String[] args) {
        int arr[][]={{1,2,3,4},{2,3,4,5},{3,4,5,6},{4,5,6,7}};
        System.out.println(Find(40,arr));
    }
    public static boolean Find ( int target, int[][] array){
            if(array.length==0||array==null||array[0].length==0)
                return false;
            int high = array.length;
            int row = array[0].length;
            int i=0,j=row-1;
            while (i<=high-1&&j>=0) {
                if (array[i][j]== target) {
                    return true;
                }else if(array[i][j]>target){
                    j--;
                }else i++;
            }
            return false;
        }
}
