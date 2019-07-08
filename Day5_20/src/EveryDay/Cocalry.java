package EveryDay;

public class Cocalry {
    public static void main(String[] args) {
                int i = 6;
                if (i == 0) {
                    return;
                }
                int temp = 0;
                while (i > 1) {
                    if (i == 2) {
                        temp += 1;
                        break;
                    }
                    int x = i / 3;
                    i -= (x * 3);
                    i += x;
                    temp += x;
                }
                System.out.println(temp);
            }
        }