package cn.lyx.Day8_30;


public class KMP {
    public static void main(String[] args) {
        String a="BBC ABCDAB ABCDABCDABDE";
        String b="ABCDABD";
        int[] adept = getAdept(b);
       int search = search(a, b, adept);
        System.out.println(search);
    }
    public static int[] getAdept(String str){
        int[] arr=new int[str.length()];
        arr[0]=0;
        for (int i = 1,j=0; i < arr.length; i++) {
            while (j>0&&str.charAt(j)!=str.charAt(i)){
                j=arr[j-1];
            }
            if(str.charAt(i)==str.charAt(j)){
                j++;
            }
            arr[i]=j;
        }
        return  arr;
    }
    public static int search(String a, String b, int[] max){
        int i=0;
        int j=0;
        while (i<a.length()){
            while (j>0&&a.charAt(i)!=b.charAt(j)){
                j=max[j-1];
            }
            if(a.charAt(i)==b.charAt(j)){
                j++;
            }
            if(j==b.length()){
                return i-j+1;
            }
            i++;
        }
        return -1;
    }
}
