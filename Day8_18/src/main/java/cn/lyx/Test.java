package cn.lyx;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.ietf.jgss.Oid;

import java.util.*;


public class Test {
    public static ArrayList<Integer> printMatrix(int[][] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        if (arr.length == 1 && arr[0].length == 1) {
            list.add(arr[0][0]);
            return list;
        }

        int a = 0;
        int b = 0;
        int c = arr[0].length - 1;
        int d = arr.length - 1;
        while (a <= c && b <= d) {
            printEdge(arr, a++, b++, c--, d--, list);
            if (d == -1) {
                break;
            }
        }
        return list;
    }

    private static void printEdge(int[][] arr, int a, int b, int c, int d, ArrayList list) {

        if (d == 0) {
            for (int i = a; i <= c; i++) {
                list.add(arr[b][i]);
            }
            return;
        }
        for (int i = a; i <= c; i++) {
            list.add(arr[b][i]);
        }

        for (int i = b + 1; i <= d; i++) {

            list.add(arr[i][c]);
        }
        for (int i = c - 1; i >= a; i--) {

            list.add(arr[d][i]);


        }
        for (int i = d - 1; i > b; i--) {
            list.add(arr[i][a]);
        }
    }

    //  {6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}
    public static boolean IsPopOrder(int[] pushA, int[] popA) {
        Deque<Integer> queue = new LinkedList();

        int i = 0;
        int j = 0;
        boolean flag = false;
        while (true) {
            while (i == pushA.length) {
                flag = true;
                while (queue.pop() == popA[j]) {
                    j++;
                    if (j >= popA.length || queue.isEmpty()) {
                        break;
                    }
                }
                break;
            }
            if (flag) {
                break;
            }
            queue.push(pushA[i]);
            boolean b = popA[j] == queue.peek();
            if (b) {
                queue.pop();
                j++;
                i++;
            } else {
                i++;
            }
            if (popA.length == 1) {
                break;
            }
        }

        if (queue.isEmpty()) {
            return true;
        } else return false;
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList();
        queue.add(root);
        ArrayList<Integer> list = new ArrayList<>();
        while (queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                TreeNode pop = queue.pop();
                list.add(pop.val);
                if (pop.left != null) {
                    queue.add(pop.left);
                }
                if (pop.right != null) {
                    queue.add(pop.right);
                }
            }
        }
        return list;
    }

    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence.length <= 0 || sequence == null) {
            return false;
        }
        boolean b = find(sequence, 0, sequence.length - 1);
        return b;
    }

    private boolean find(int[] arr, int start, int end) {
        int root = arr[end];
        int temp = 0;
        for (int i = 0; i <= end; i++) {
            if (arr[i] > root) {
                temp = i;
                break;
            }
        }
        while (temp <= end) {
            if (arr[temp++] < root) {
                return false;
            }
        }
        boolean b = find(arr, start, temp - 1);
        boolean b1 = find(arr, temp, end);
        return b && b1;
    }

    static class Nan implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            return o1.nan - o2.nan;
        }
    }

    static class Money implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            return -(o1.money - o2.money);
        }
    }

    static class Node {
        public Integer nan;
        public Integer money;

        public Node(Integer nan, Integer money) {
            this.nan = nan;
            this.money = money;
        }
    }

    public static void sout() {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        ArrayList<Node> list = new ArrayList<>();
        int[] arr = new int[b];
        for (int i = 0; i < a; i++) {
            list.add(new Node(sc.nextInt(), sc.nextInt()));
        }
        for (int i = 0; i < b; i++) {
            arr[i] = sc.nextInt();
        }
        PriorityQueue<Node> money = new PriorityQueue<Node>(new Money());
        PriorityQueue<Node> nan = new PriorityQueue<>(new Nan());
        nan.addAll(list);
        for (int i = 0; i < b; i++) {
            while (arr[i] >= nan.peek().nan) {
                Node poll = nan.poll();
                money.add(poll);
                if (nan.isEmpty()) {
                    break;
                }
            }
            if (money.isEmpty()) {
                System.out.println(0);
            } else {
                System.out.println(money.peek().money);
                nan.addAll(money);
                while (!money.isEmpty()) {
                    money.poll();
                }
            }

        }
    }

    public static void test() {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
//    if(a!='1'){
//        String string = "1";
//    }
//    String string="";
        int j = 0;
        for (int i = a; i <= b; i++) {
            //string=string+i;
            if (i % 3 == 2 || i % 3 == 0) {
                // System.out.println(string);
                j++;
            }
        }
        System.out.println(j);
    }

    public static void test1() {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        for (int i = 0; i < a; i++) {
            int m=sc.nextInt();
            String string = sc.next();
            int q = 0;
            for(int j=0;j<m;j++){
                if (string.charAt(j) == '.') {
                    j +=2;
                    q++;
                }
            }
            System.out.println(q);
            q = 0;
        }
    }


    public static void main(String[] args) {
        test1();
    }
}
