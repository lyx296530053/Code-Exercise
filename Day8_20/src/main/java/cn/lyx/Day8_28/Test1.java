package cn.lyx.Day8_28;

import java.util.*;

public class Test1 {
    public static void test1() {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int[] arr = new int[x];
        for (int i = 0; i < x; i++) {
            arr[i] = scanner.nextInt();
        }
        ArrayList<Integer> list = new ArrayList<>();
        int temp = arr[0];
        int a = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i + 1] < arr[i]) {
                list.add(arr[i]);
                list.add(arr[i + 1]);
                i += 2;
                while (i < arr.length) {
                    if (arr[i] < list.get(list.size() - 1)) {
                        list.add(arr[i]);
                    } else {
                        a = i - list.size();
                        break;
                    }
                    i++;
                }
                break;
            }
        }
        Collections.reverse(list);

        for (int i = 0; i < list.size(); i++) {
            arr[a++] = list.get(i);
        }
        for (int i = 0; i < arr.length; i++) {
            if (i + 1 == arr.length) {
                break;
            }
            if (arr[i + 1] < arr[i]) {
                System.out.println("no");
            }

        }
        System.out.println("yes");
    }

    public static void test2() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String ss = scanner.nextLine();
        int temp = 0;
        for (int i = 0; i < s.length(); i++) {
            if (((s.charAt(i) >= '0' && s.charAt(i) <= '9') || (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')) && ss.charAt(i) == '1') {
                temp++;
            } else if ((s.charAt(i) < '0' || s.charAt(i) > '9' && s.charAt(i) < 'A' || s.charAt(i) > 'Z' && s.charAt(i) < 'a' || s.charAt(i) > 'z') && ss.charAt(i) == '0') {
                temp++;
            }
        }
        float out = (float) temp * 100 / (float) s.length();
        System.out.printf("%.2f%%", out);
    }


    void test3() {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int length = scanner.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        int to = 0;
        while (true) {

        }
    }

    public static void test4() {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int temp = 0;
        int num = 0;
        for (int i = 0; i < size; i++) {
            int out = scanner.nextInt();
            int in = scanner.nextInt();
            num = in - out + num;
            temp = Math.max(temp, num);
        }
        System.out.println(temp);
    }

    public static void test5() {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int[] arr = new int[a];
        for (int i = 0; i < a; i++) {
            arr[i] = scanner.nextInt();
        }
        for (int i = 0; i < b; i++) {
            int qa = scanner.nextInt();
            int c = scanner.nextInt();
            int d = scanner.nextInt();
            switch (qa) {
                case 1:
                    ex1(arr, c, d);
                    break;
                case 2:
                    int i1 = ex2(arr, c, d);
                    System.out.println(i1);
                    break;
                case 3:
                    int i2 = ex3(arr, c, d);
                    System.out.println(i2);
                    break;
            }
        }
    }

    public static void ex1(int[] arr, int a, int b) {
        arr[a - 1] = b;
    }

    public static int ex2(int[] arr, int a, int b) {
        int num = 0;
        for (int i = a - 1; i < b; i++) {
            num += arr[a];
        }
        return num;
    }

    public static int ex3(int[] arr, int a, int b) {
        int num = 0;
        for (int i = a - 1; i < b; i++) {
            num = Math.max(arr[i], num);
        }
        return num;
    }

    public static void test6() {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int group = scanner.nextInt();
        HashSet<Integer> hashSet = new HashSet<>();
        TreeMap<Integer, Integer> hashMap = new TreeMap<>();
        hashSet.add(1);
        while (true) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            if (a == 0 && b == 0) {
                break;
            }
            if (hashSet.contains(a) || hashSet.contains(b)) {
                hashSet.add(a);
                hashSet.add(b);
                while (hashSet.contains(hashMap.get(a))||hashSet.contains(hashMap.get(b))){
                    hashSet.add(hashMap.get(a));
                    hashSet.add(hashMap.get(b));
                }
            } else {
                hashMap.put(a, b);
                hashMap.put(b, a);
            }
        }
        for (Integer integer : hashMap.keySet()) {
            if(hashSet.contains(integer)){
                hashSet.add(hashMap.get(integer));
            }
        }
            System.out.println(hashSet.size() - 1);
    }

    public static void main(String[] args) {
        test5();
    }
}
