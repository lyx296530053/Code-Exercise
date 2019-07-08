package Every;


import java.util.Scanner;

public class Test02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String str1 = sc.nextLine();
        System.out.println(str.length());
        show(str, str1);
    }

    public static void show(String str1, String str2) {
        if(str2==null){
            System.out.println(str1);
        }
        int[] arr = new int[str1.length()];
        int x = 0;
        for (int i = 0; i < str1.length(); i++) {
            int j = str2.length() - 1;
            int w = 0;
            for (int k = 0; k <= j; k++) {
                if (str1.charAt(i) == str2.charAt(k)) {
                    break;
                } else {
                    w++;
                }
                if (w == j + 1) {
                    System.out.print(str1.charAt(i));
                }
            }
        }
    }
}

