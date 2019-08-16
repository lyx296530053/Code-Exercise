package cn.lyx.linkList;

public class Test2 {
    public static void main(String[] args) {
        int[][] arr = new int[3][3];
        arr[0][0] = 1;
        arr[0][1] = 2;
        arr[1][0] = 0;
        arr[1][1] = 0;
        int max = 0;
        int min = 0;
        int m = 3, n = 3;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] > max) {
                    max = arr[i][j];
                }
                min = min == 0 ? arr[i][j] : Math.min(min, arr[i][j]);
            }
        }
        int temp = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] >= min && arr[i][j] != 0) {
                    if (arr[i][j] == 1) {
                        temp += ((arr[i][j] - min) * 6);
                    } else
                        temp += ((arr[i][j] - min) * 6 - 2);
                } else if (arr[i][j] == 0) {
                    continue;
                }
                if (j + 1 >= n) {
                    continue;
                }
                if (arr[i][j + 1] >= arr[i][j]) {
                    temp -= arr[i][j] * 2;
                } else {
                    temp -= arr[i][j + 1] * 2;
                }
                if (i + 1 >= m) {
                    continue;
                }
                if (arr[i + 1][j] >= arr[i][j]) {
                    temp -= arr[i][j] * 2;
                } else {
                    temp -= arr[i + 1][j] * 2;
                }
            }
        }
        System.out.println(temp);
    }
}
