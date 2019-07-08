package Everday;

import java.util.Scanner;

public class Test02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] split = line.split(" ");
        int[] temp = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            temp[i] = Integer.parseInt(split[i]);
        }
        for (int i = 0; i < temp.length; i++) {
            int value = temp[i];
            int x = 0;
            for (int k = i + 1; k < temp.length; k++) {
                if (value == temp[k]) {
                    x++;
                } else {
                    x--;
                }
                if (x <=0) {
                    break;
                }
                if (k == temp.length - 1) {
                    break;
                }
            }
            if (x > 0) {
                System.out.println(value);
                break;
            }
        }
    }
}
