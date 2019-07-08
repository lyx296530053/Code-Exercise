package cn.lyx.everday;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int x=scanner.nextInt();
        int y=scanner.nextInt();
            int[][] dp=new int[x][y];
        if(x==0||y==0){

        }else if(x==1||y==1){

        }
        for (int j=0;j<y;j++) {
            dp[0][j]=1;
        }
        for (int i = 0; i <x ; i++) {
          dp[i][0]=1;
        }
        for (int i = 1; i<x ; i++) {
            for (int j = 1; j <y ; j++) {
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        System.out.println(dp[x-1][y-1]);

    }
}
