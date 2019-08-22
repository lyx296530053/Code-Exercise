package cn.lyx.Test1;

import java.util.*;

public class MyTest {
    public static void test1() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] split = s.split(" ");
        if (split.length == 1) {
            for (int i = 0; i < split[0].length(); i++) {
                System.out.print(split[0].charAt(i) + " ");
            }
        }
        LinkedHashSet set = new LinkedHashSet();
        int temp = 0;
        for (int i = 0; i < split.length; i++) {
            temp = Math.max(split[i].length(), temp);
        }
        for (int i = 0; i < temp; i++) {
            for (int j = 0; j < split.length; j++) {
                if (i >= split[j].length()) {
                    continue;
                }
                set.add(split[j].charAt(i));
            }
        }
        for (Object character : set) {
            System.out.print(character + " ");
        }
    }

    public static void test2() {
        String s = "MPMPCPMCMDEFEGDEHINHKLIN";
        ArrayList<Integer> list = new ArrayList();
        char c = s.charAt(0);
        int temp = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                temp = i;
            }
        }
        if (temp == s.length() - 1) {
            System.out.println(temp + 1);
            return;
        } else System.out.println(temp + 1);

        while (temp != s.length() - 1) {
            char c1 = s.charAt(temp + 1);
            int s1 = temp;
            for (int i = temp + 2; i < s.length(); i++) {
                if (s.charAt(i) == c1) {
                    temp = i;
                }
            }
            s1 = temp - s1 + 1;
            while (temp != s.length() - 1) {
                String string = String.valueOf(s.charAt(temp + 1));
                String substring = s.substring(0, temp);
                if (substring.contains(string)) {
                    s1 += 1;
                    temp += 1;
                } else break;
            }
            System.out.println(s1);
        }
    }

    public static void test3() {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[][] arr = new int[num][2];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        compare(arr);
        int minute = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int i = a * 60 + b - minute;
        a = i / 60;
        b = i % 60;
        for (i = arr.length - 1; i >= 0; i--) {
            if (arr[i][0] > a) {
                continue;
            }
            if (arr[i][0] == a && arr[i][1] > b) {
                continue;
            }
            if (arr[i][0] <= a && arr[i][1] <= b) {
            }
            System.out.println(arr[i][0] + " " + arr[i][1]);
            break;
        }
    }

    private static void compare(int[][] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j][0] > arr[j + 1][0]) {
                    int temp = arr[j][0];
                    arr[j][0] = arr[j + 1][0];
                    arr[j + 1][0] = temp;
                    temp = arr[j][1];
                    arr[j][1] = arr[j + 1][1];
                    arr[j + 1][1] = temp;
                }
            }
        }
    }

    public static void test4() {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int add = scanner.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = scanner.nextInt();
        }
        int temp=0;
        for (int i : arr) {
            temp+=i;
        }
        if(temp<=add){
            System.out.println((int) Math.pow(2,temp));
        }

    }
    public static int test5(int[] arr,int temp,int add,int flag){
        int num=0;
        if(temp==flag){

            for (int i = 0; i <=temp; i++) {
                num+=arr[i];
            }
        }else {

            for (int i = 0; i <=flag; i++) {
                num+=arr[i];
            }
        }
        if(num>add){
            return 0;
        }else return (int) Math.pow(2,temp);

    }

    public static void main(String[] args) {
        int i = test5(new int[]{1, 2, 5}, 0, 8, 0);
        System.out.println(1);
    }


}
