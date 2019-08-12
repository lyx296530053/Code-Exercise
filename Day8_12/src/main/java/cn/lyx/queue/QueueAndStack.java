package cn.lyx.queue;

import org.junit.Test;

import java.util.*;

public class QueueAndStack {
    public static class MyQueue {
        private Integer[] arr;
        private Integer size;
        private Integer first;
        private Integer last;

        public MyQueue(int initSize) {
            if (initSize < 0) {
                throw new IllegalArgumentException("The init size is less than 0");
            }
            arr = new Integer[initSize];
            size = 0;
            first = 0;
            last = 0;
        }

        public void push(int n) {
            if (size == arr.length) {
                throw new ArrayIndexOutOfBoundsException("queue is full");
            }
            size++;
            arr[last] = n;
            last = last == arr.length - 1 ? 0 : last + 1;
        }

        public int poll() {
            if (size == 0) {
                throw new ArrayIndexOutOfBoundsException("The queue is empty");
            }
            size--;
            int temp = first;
            first = first == arr.length - 1 ? 0 : first + 1;
            return arr[temp];
        }

        public Integer peek() {
            if (size == 0) {
                throw new ArrayIndexOutOfBoundsException("The queue is empty");
            }
            return arr[first];
        }
    }

    public static class MyStack {
        private int[] arr;
        int size;

        public MyStack(int n) {
            arr = new int[n];
            size = 0;
        }

        public void push(int n) {
            if (size == arr.length) {
                throw new ArrayIndexOutOfBoundsException("stack is full");
            }
            arr[size++] = n;
        }

        public int poll() {
            if (size == 0) {
                throw new ArrayIndexOutOfBoundsException("stack is empty");
            }
            int i = arr[--size];
            return i;
        }

        public Integer peek() {
            if (size == 0) {
                throw new ArrayIndexOutOfBoundsException("stack is empty");
            }
            return arr[size - 1];
        }
    }

    public static class StackByMin {
        private java.util.Stack<Integer> stackData;
        private java.util.Stack<Integer> stackMin;

        public StackByMin() {
            this.stackData = new java.util.Stack<Integer>();
            this.stackMin = new java.util.Stack<Integer>();
        }

        public void push(int newNum) {
            if (this.stackMin.isEmpty()) {
                this.stackMin.push(newNum);
            } else if (newNum <= this.getmin()) {
                this.stackMin.push(newNum);
            }
            this.stackData.push(newNum);
        }

        public int pop() {
            if (this.stackData.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }
            int value = this.stackData.pop();
            if (value == this.getmin()) {
                this.stackMin.pop();
            }
            return value;
        }

        public int getmin() {
            if (this.stackMin.isEmpty()) {
                throw new RuntimeException("Your stack is empty.");
            }
            return this.stackMin.peek();
        }
    }

    /**
     * 栈实现队列
     */
    public static class StackToQueue {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> temp = new Stack<>();

        public void push(int n) {
            stack.push(n);
        }

        public int poll() {
            if (temp.isEmpty()) {
                while (!stack.isEmpty()) {
                    temp.push(stack.pop());
                }
            }
            return temp.pop();
        }

        public void peek() {
            if (temp.isEmpty()) {
                while (!stack.isEmpty()) {
                    temp.push(stack.pop());
                }
            }
            temp.peek();
        }
    }

    /**
     * 队列实现栈
     */
    public static class QueueToStack {
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> temp = new LinkedList<>();

        public void push(int n) {
            queue.add(n);
        }

        public int pop() {
            if (queue.size() == 0) {
                throw new RuntimeException("stack is empty");
            }
            while (queue.size() > 1) {
                temp.add(queue.poll());
            }
            int value = queue.poll();
            Queue s = queue;
            queue = temp;
            temp = s;
            return value;
        }

        public int peek() {
            if (queue.size() == 0) {
                throw new RuntimeException("stack is empty");
            }
            while (!queue.isEmpty()) {
                temp.add(queue.poll());
            }
            int value = temp.peek();
            Queue s = queue;
            queue = temp;
            temp = s;
            return temp.peek();
        }
    }

    /**
     * 转圈打印矩阵
     */
    public static void printMatrix(int[][] arr) {
        int a = 0;
        int b = 0;
        int c = arr[0].length - 1;
        int d = arr.length - 1;
        while (a < c && b < d) {
            printEdge(arr, a++, b++, c--, d--);
        }
    }

    private static void printEdge(int[][] arr, int a, int b, int c, int d) {
        for (int i = a; i <= c; i++) {
            System.out.print(arr[b][i] + " ");
        }
        for (int i = b + 1; i <= d; i++) {
            System.out.print(arr[i][c] + " ");
        }
        for (int i = c - 1; i >= a; i--) {
            System.out.print(arr[d][i] + " ");
        }
        for (int i = d - 1; i > b; i--) {
            System.out.print(arr[i][a] + " ");
        }
    }

    /**
     * “之”字形打印矩阵
     */
    public static void printfZhi(int[][] arr) {
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        int endRow = arr.length - 1;
        int endColumn = arr[0].length - 1;
        boolean flag = false;
        while (a != endRow + 1) {
            printfLevel(arr, a, b, c, d, flag);
            a = b == endColumn ? a + 1 : a;
            b = b == endColumn ? b : b + 1;
            d = c == endRow ? d + 1 : d;
            c = c == endRow ? c : c + 1;
            flag = !flag;
        }
    }

    private static void printfLevel(int[][] arr, int a, int b, int c, int d, boolean flag) {
        if (flag) {
            while (c >= a) {
                System.out.print(arr[c--][d++] + " ");
            }
        } else {
            while (a <= c) {
                System.out.print(arr[a++][b--] + " ");
            }
        }
    }

    public static boolean findNum(int[][] arr, int num) {
        int row = arr.length;
        int column = arr[0].length;
        int i = 0;
        int j = column - 1;
        boolean flag = false;
        while (i <= row - 1 && j >= 0) {
            if (arr[i][j] == num) {
                flag = true;
                break;
            } else if (arr[i][j] > num) {
                j--;
            } else
                i++;
        }
        return flag;
    }

    public static String getNum(String str) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= '1' && str.charAt(i) <= '9') {
                sb.append(str.charAt(i));
            } else {
                if (sb1.length() == 0 || sb.length() > sb1.length()) {
                    sb1.delete(0, sb1.length());
                    sb1.append(sb.toString());
                    sb.delete(0, sb.length());
                } else sb.delete(0, sb.length());
            }
        }
        return sb1.toString();
    }

    public static void getMin(int[] arr, int n) {
        ArrayList list = new ArrayList();
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            list.add(arr[i]);
        }
        System.out.println(list.toString());
    }

    public static void main(String[] args) {
        String num = getNum("123qw54ewe56q51e3q1we56q1e11233q1q");
        System.out.println(num);
        //getMin(new int[]{1, 5, 8, 9, 5, 7, 8, 9, 5, 45, 64, 89, 4, 45, 4654, 4, 5, 5, 8, 4, 5, 25, 4, 5}, 5);
//        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
//        boolean num = findNum(matrix, 1);
//        System.out.println(num);
    }
}
