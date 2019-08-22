package cn.lyx.Test1;

import java.util.Scanner;

public class MyTest1 {
    static int res = 0;//种类计数
    //n:零食的数量
    //w:背包的容量
    //v:每袋零食的体积
    //i:考虑到第几个零食了
    //cw:目前背包内已有的零食总重（必须定义为long，否则求和溢出，AC80%）
    public static void solution(int n,int w,int[] v,int i,long cw){
        //回溯算法思想
        if(i<n){  //未全部考虑完
            solution(n,w,v,i+1,cw);//不放当前i的零食，直接考虑i+1
            if(cw+v[i]<=w){ //放当前i的零食
                res++;
                solution(n,w,v,i+1,cw+v[i]);
            }
        }

    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int w = scanner.nextInt();
        int[] v = new int[n];
        long sum = 0;
        for(int i=0;i<n;i++){
            v[i]=scanner.nextInt();
            sum=sum+v[i];
        }
        if(sum<=w)
            System.out.println((int)Math.pow(2,n));
        else{
            solution(n,w,v,0,0);
            System.out.println(res+1);
        }
    }
}
