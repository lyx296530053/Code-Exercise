package cn.lyx.queen8;

public class Queen8 {
    int max=8;
    int[] arr=new int[max];
    public boolean check(int n){
        for (int i = 0; i < n; i++) {
            if(arr[i]==arr[n]||Math.abs(n-i)==Math.abs(arr[n]-arr[i])){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {

    }
}
