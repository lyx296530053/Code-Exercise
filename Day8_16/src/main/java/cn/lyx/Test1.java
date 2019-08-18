package cn.lyx;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Test1 {


    public int RectCover(int target) {
        if (target == 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        return RectCover(target - 1) + RectCover(target - 2);
    }

    public static int NumberOf1(int n) {
        int temp = 0;
        if (n == 0) {
            return 0;
        } else if (n > 0) {
            while (n / 2 > 0) {
                int s = n % 2;
                if (s == 1) {
                    temp++;
                }
                n = n / 2;
            }
            temp += 1;
        } else {

            while (n / 2 > 0) {
                int s = n % 2;
                if (s == 1) {
                    temp++;
                }
                n = n / 2;
            }
            temp += 1;

        }
        return temp;
    }

    public double Power(double base, int power) {
        double result = 1;
        int abs = Math.abs(power);
        while (abs > 0) {
            if (abs % 2 == 0) {
                abs = abs / 2;
                base = base * base;
            } else {
                abs = abs - 1;
                result = result * base;
                abs = abs / 2;
                base = base * base;
            }
        }
        if (power < 0) {
            result = 1 / result;
        }
        return result;

    }

    public static void reOrderArray(int[] array) {
        // mergeSort(array,0,array.length-1);
        bubbleSort(array);
    }

    public static void bubbleSort(int[] arr) {
        if (arr.length < 2) {
            return;
        }
        for (int i = arr.length - 1; i >= 0; i--) {

            for (int j = 0; j < i; j++) {
                if (arr[j] % 2 == 0 && arr[j + 1] % 2 != 0) {
                    swap(arr, j + 1, j);
                }
            }
        }
    }

    public static void mergeSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = (low + high) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    public static void merge(int[] arr, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int[] temp = new int[high - low + 1];
        int k = 0;
        while (i <= mid && j <= high) {
            if (arr[i] % 2 != 0) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        int start = i;
        int end = mid;
        if (high >= j) {
            start = j;
            end = high;
        }
        while (start <= end) {
            temp[k++] = arr[start++];
        }
        for (i = 0; i <= high - low; i++) {
            arr[i + low] = temp[i];
        }
    }

    public static void swap(int[] arr, int low, int hight) {
        int temp = arr[low];
        arr[low] = arr[hight];
        arr[hight] = temp;
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindKthToTail(ListNode head, int k) {
        ListNode temp = head;
        int n = 0;
        while (temp != null) {
            n++;
            temp = temp.next;
        }
        for (int i = 0; i < n - k; i++) {
            head = head.next;
        }
        return head;
    }

    public static ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        } else if (list1 == null && list2 != null) {
            return list2;
        } else if (list1 != null && list2 == null) {
            return list1;
        } else {
            ListNode temp = new ListNode(Math.min(list1.val, list2.val));
            ListNode t = temp;
            if (temp.val == list1.val) {
                list1 = list1.next;
            } else list2 = list2.next;
            while (list1 != null && list2 != null) {
                if (list1 == null) {
                    while (list2 != null) {
                        temp.next = new ListNode(list2.val);
                        temp = temp.next;
                        list2 = list2.next;
                    }
                    break;
                } else if (list2 == null) {
                    while (list1 != null) {
                        temp.next = new ListNode(list1.val);
                        temp = temp.next;
                        list1 = list1.next;
                    }
                    break;
                }
                temp.next = new ListNode(Math.min(list1.val, list2.val));
                temp = temp.next;
                if (temp.val == list1.val) {
                    list1 = list1.next;
                } else list2 = list2.next;
            }
            return t;
        }
    }

    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public static boolean HasSubtree(TreeNode root1, TreeNode root2) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();
        test1(root1, sb);
        test1(root2, sb1);
        boolean b = sb.toString().contains(sb1.toString());
        return b;
    }

    public static void test1(TreeNode root, StringBuilder sb) {
        if (root != null) {
            if(root.val=='#'){
                sb.append("#_");
                return;
            }
            test1(root.left, sb);
            sb.append(root.val + "_");
            test1(root.right, sb);

        } else {
            sb.append("#_");
        }
    }
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list=new ArrayList<>();
        if(arr.length==1&&arr[0].length==1){
            return list.add(arr[0][0]);
        }

        int a = 0;
        int b = 0;
        int c = arr[0].length - 1;
        int d = arr.length - 1;
        while (a <c && b < d) {
            printEdge(arr, a++, b++, c--, d--,list);
        }
        return list;
    }

    private static void printEdge(int[][] arr, int a, int b, int c, int d,ArrayList list) {
        for (int i = a; i <= c; i++) {
            list.add(arr[b][i]);
        }
        for (int i = b+1; i <= d; i++) {
            list.add(arr[i][c]);
        }
        for (int i = c - 1; i >= a; i--) {
            list.add(arr[d][i]);
        }
        for (int i = d - 1; i > b; i--) {
            list.add(arr[i][a]);
        }
    }
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(6);
        TreeNode treeNode4 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(8);
        TreeNode treeNode6 = new TreeNode(2);
        TreeNode treeNode7 = new TreeNode(5);
        TreeNode treeNode8 = new TreeNode(7);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = null;
        treeNode3.right = treeNode8;
        treeNode4.left = null;
        treeNode4.right = null;
        treeNode5.left = treeNode6;
        treeNode5.right = treeNode7;
        treeNode6.left = null;
        treeNode6.right = null;
        treeNode7.left = null;
        treeNode7.right = null;
        treeNode8.left = null;
        treeNode8.right = null;
        TreeNode treeNodeA = new TreeNode(8);
        treeNodeA.left = null;
        treeNode1.right = treeNode7;
        boolean b = HasSubtree(treeNode1, treeNodeA);
        System.out.println(b);
    }
}
