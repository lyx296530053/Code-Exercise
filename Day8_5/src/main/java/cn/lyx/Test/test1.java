package cn.lyx.Test;

import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[6];
        for (int i = 0; i < 6; i++) {
            arr[i] = sc.nextInt();
        }
        int x = sc.nextInt();
        int a = 0;
        for (int i = 0; i <= arr[0]; i++) {
            for (int j = 0; j <= arr[1]; j++) {
                for (int k = 0; k <= arr[2]; k++) {
                    for (int l = 0; l <= arr[3]; l++) {
                        for (int m = 0; m <= arr[4]; m++) {
                            for (int n = 0; n <= arr[5]; n++) {
                                if (i + j* 5 + k * 10 + l * 20 + m * 50 + n * 100 == x) {
                                    if (i != 0) {
                                        a += 1;
                                    }
                                    if (j != 0) {
                                        a += 1;
                                    }
                                    if (k != 0) {
                                        a += 1;
                                    }
                                    if (l != 0) {
                                        a += 1;
                                    }
                                    if (m != 0) {
                                        a += 1;
                                    }
                                    if (n != 0) {
                                        a += 1;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if(a!=0){
            System.out.println(a);
        }else System.out.println(-1);

    }
}
