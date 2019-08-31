package cn.lyx.Day8_29;

import java.util.*;

public class Test {
    public static void midToAft() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                System.out.print(s.charAt(i));

            } else {
                if (stack.isEmpty()) {
                    stack.push(s.charAt(i));
                } else {
                    Character peek = stack.peek();
                    if (peek == '(') {
                        stack.push(s.charAt(i));
                    } else if ((s.charAt(i) == '-' || s.charAt(i) == '+') && ((peek == '*' || peek == '/') || (peek == '-' || peek == '+'))) {
                        while (!stack.isEmpty()) {
                            Character pop = stack.pop();
                            System.out.print(pop);
                        }
                        stack.push(s.charAt(i));
                    } else if ((s.charAt(i) == '*' || s.charAt(i) == '/') && (peek == '*' || peek == '/')) {
                        while (!stack.isEmpty() && (s.charAt(i) == '*' || s.charAt(i) == '/') && (stack.peek() == '*' || stack.peek() == '/')) {
                            System.out.print(stack.pop());
                        }
                        stack.push(s.charAt(i));
                    } else stack.push(s.charAt(i));
                    if (s.charAt(i) == ')') {
                        while (stack.peek() != '(') {
                            System.out.print(stack.pop());
                        }
                        stack.pop();
                    }
                }
            }
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }

    public static void min() {
        System.out.println(min.peek());
    }

    public static void push(int a) {
        stack.push(a);
        if (min.isEmpty()) {
            min.push(a);
        } else {
            if (min.peek() > a) {
                min.push(a);
            } else {
                min.push(min.peek());
            }
        }
    }

    public static void pop() {
        Integer pop = stack.pop();
        System.out.println(pop);
        while (pop == min.peek()) {
            min.pop();
        }
    }

    public static Stack<Integer> stack = new Stack();
    public static Stack<Integer> min = new Stack();

    public static void getNumber() {
        String s = "787585";
        char[] chars = s.toCharArray();
        TreeMap<Character, Integer> map = new TreeMap<>();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                map.replace(chars[i], map.get(chars[i]), map.get(chars[i]) + 1);
            } else {
                map.put(chars[i], 1);
            }
        }
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        int max = Integer.MIN_VALUE;
        int temp = 0;
        for (Map.Entry<Character, Integer> entry : entries) {
            if (max == Integer.MIN_VALUE) {
                max = entry.getValue();
            } else if (entry.getValue() == max) {
                temp++;
            } else if (entry.getValue() > max) {
                max = entry.getValue();
                if (temp != 0) {
                    temp = 0;
                }
            }
        }
        if (temp == 0) {
            Character key = ' ';
            for (Map.Entry<Character, Integer> entry : entries) {
                if (entry.getValue() == max) {
                    key = entry.getKey();
                }
            }

        } else {
            char[] chars1 = new char[s.length()];
            int i = 0;
            for (Map.Entry<Character, Integer> entry : entries) {
                if (entry.getValue() == max) {
                    chars1[i++] = entry.getKey();
                }
            }

        }
    }

    public static void test1() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList();
        while (scanner.hasNextInt()) {
            list.add(scanner.nextInt());
        }
        Integer[] integers = list.toArray(new Integer[list.size()]);
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < integers.length; i++) {
            hashSet.add(integers[i]);
        }
        if (hashSet.size() == 1) {
            System.out.println(0);
        }
        Arrays.sort(integers);
        int a = 0;
        int temp = 0;
        for (int i = 0; i < integers.length; i++) {
            if (integers[i] > integers[temp]) {
                a += (integers[i] - integers[temp]);

            }
            temp = i;
        }
        System.out.println(a);
    }

    public static int test2(int temp, int x) {
        if (x - temp == 1 || x - temp == 2 || x - temp == 3 || x - temp == 4) {
            return 1;
        }
        return test2(temp + 4, x) + test2(temp + 3, x) + test2(temp + 2, x) + test2(temp + 1, x);
    }

    public static void test4() {
        Scanner scanner=new Scanner(System.in);
        int i1 = scanner.nextInt();
        for (int i = 0; i < i1; i++) {
            int a=scanner.nextInt();
            int b=scanner.nextInt();
            if(b==0||b==1||a==b){
                System.out.println('0'+" "+'0');
            }else if(a>=(b*2)){
                System.out.println("0"+" "+(b-1));
            }
            else {
                System.out.println('0'+" "+(a-b));
            }
        }
    }

    public static void main(String[] args) {
     test4();
    }
}


