package every;

import java.util.Scanner;

public class Test02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        int[][] dp = new int[50][50];
        int[] a = new int[50];
        for (int i = 0; i <= n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i <= 40; i++) {
            for (int j = 1; j <= n; j++) {
                if (i - a[j] >= 0) {
                    dp[i][j] = dp[i][j - 1] + dp[i - a[j]][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        System.out.println(dp[40][n]);
    }
}
