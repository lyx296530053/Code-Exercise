package cn.lyx.Test;

import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String num1 = sc.nextLine();
        String num2 = sc.nextLine();

        String sum = add(num1, num2);
        System.out.println(sum);
    }

    private static String add(String num1, String num2) {
        String[] split = num1.split("\\.");
        String[] split1 = num2.split("\\.");

        int i2 = split[0].length() > split1[0].length() ? split[0].length() + 1 : split1[0].length() + 1;
        int i1 = split[1].length() > split1[1].length() ? split[1].length() + 1 : split1[1].length() + 1;
        int temp = 0;
        char[] ss = new char[i1];
        char[] qq = new char[i2];
        int length1 = i2;
        int length = i1;
        int x = 0;
        for (int i = 0; i < i1; i++) {
                if (split[1].charAt(i) == 0) {
                    int s = split1[1].charAt(i) + temp;
                } else if (split1[1].charAt(i) == 0) {
                    int s = split[1].charAt(i) + temp;
                } else {
                    int s = split[1].charAt(i) + split1[1].charAt(i) + temp;
                    ss[x++] = (char) s;
                    if (s > 9) {
                        temp = s - 9;
                    }
                }
            }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(ss.toString().trim() + ".");
        for (int i = split[0].length() - 1; i >= 0; i--) {
            for (int j = split1[0].length() - 1; j >= 0; j--) {
                int s = split[0].charAt(i) + split1[0].charAt(j) + temp;
                qq[length--] = (char) s;
                if (s > 9) {
                    temp = s - 9;
                }
            }
        }
        stringBuilder.append(qq.toString().trim());
        return stringBuilder.toString();
    }
}
