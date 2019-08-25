package cn.lyx.Day8_23;


import java.util.*;

public class Test1 {
    public static void test1() {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int[] arr = new int[a];
        for (int i = 0; i < b; i++) {
            int s = 0;
            s = scanner.nextInt();
            arr[s - 1]++;
        }
        Arrays.sort(arr);
        System.out.println(arr[0]);
    }

    public static void test2() {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int[] interest = new int[a];
        int[] know = new int[a];
        for (int i = 0; i < a; i++) {
            interest[i] = scanner.nextInt();
        }
        for (int i = 0; i < a; i++) {
            know[i] = scanner.nextInt();
        }
        if (b == 0) {
            int sum = 0;
            for (int i = 0; i < a; i++) {
                if (know[i] == 1) {
                    sum += interest[i];
                }
            }
            System.out.println(sum);
            return;
        }
        int sum = 0;
        int temp = 0;
        for (int i = 0; i < a; i++) {
            if (know[i] == 1) {
                sum += interest[i];
            } else {
                int temp1 = 0;
                for (int j = i; j < i + b && j < a; j++) {
                    if (know[j] != 1) {
                        temp1 += interest[j];
                    }
                }
                temp = Math.max(temp, temp1);
            }
        }
        System.out.println(sum + temp);
    }

    public static void test3() {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int[] interest = new int[a];
        int nn = 0;
        for (int i = 0; i < a; i++) {
            int sss = scanner.nextInt();
            interest[i] = sss + nn;
            nn = interest[i];
        }
        int b = scanner.nextInt();
        int[] know = new int[a];
        for (int i = 0; i < b; i++) {
            know[i] = scanner.nextInt();
        }
        for (int i = 0; i < b; i++) {
            int index = Arrays.binarySearch(interest, know[i]);
            if (index > 0) {
                System.out.println(index + 1);
            } else {
                System.out.println(-index);
            }
        }
    }

    public static void test4() {


        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//塔的数量
        int k = sc.nextInt();//最多操作次数
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        int max = Collections.max(list);
        int min = Collections.min(list);
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        int count = 0;
        while (max - min > 1 && count < k) {
            max = Collections.max(list);
            min = Collections.min(list);
            list1.add(list.indexOf(max) + 1);
            list2.add(list.indexOf(min) + 1);
            list.set(list.indexOf(max), max - 1);
            list.set(list.indexOf(min), min + 1);
            count++;
        }
        System.out.println((Collections.max(list) - Collections.min(list)) + " " + count);
        for (int i = 0; i < count; i++) {
            System.out.println(list1.get(i) + " " + list2.get(i));
        }
    }

    public static void test5() {

    }

    public static void test6() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int a = 0;
        int b = arr.length - 1;
        int c = n % 2;
        int i = n / 2;
        int temp=0;
        if (c == 1) {
            int a1 = arr[0];
            int a2 = arr[b];
            while (a <=b) {
                if(a==b){
                    int ss=a1;
                    a1+=arr[a];
                    if(a1==a2){
                        temp=a1;
                    }
                    a2+=arr[a];
                    if(ss==a2){
                        temp=ss;
                    }
                    break;
                }
                if(a1>a2){
                    b--;
                    a2 += arr[b];
                }else if(a1<a2){
                    a++;
                    a1 += arr[a];
                }else {
                    temp = a1;
                    a++;
                    b++;
                }
            }
        } else{
            int a1 = 0;
            int a2 = 0;
            while (a <=b) {
                a1 += arr[a];
                a2 += arr[b];
                if(a1>a2){
                    b--;
                }else if(a1<a2){
                    a++;
                }else {
                    temp = a1;
                }
            }
        }
        System.out.println(temp);
    }

    public static void main(String[] args) {
        test6();
    }
}
