package cn.lyx.everday;

public class Test1 {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        Test1 test1 = new Test1();
        int[] multiply = test1.multiply(arr);
        for (int i : multiply) {
            System.out.print(i + " ");
        }
    }

    public int[] multiply(int[] A) {
        int[] B=new int[A.length];
        for (int i = 0; i < A.length; i++) {
            System.out.println("sign4");
            B[i]=add(A,i);
        }
        System.out.println("sign1");
        return B;
    }
    public int add(int[] arr,int i){

        int temp=1;
        int length = arr.length-1;
        while(length>=0){
            if(length==i){
                length--;
                continue;
            }
           temp*=arr[length];
           length--;
            System.out.println("sign2");
       }
        System.out.println("sign3");
        return temp;
    }
}
