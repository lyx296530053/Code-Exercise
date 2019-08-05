package cn.lyx;

import com.sun.scenario.effect.Merge;

import java.util.*;

public class DoubleHand {
    public static int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[]{i + 1, j + 1};
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return null;
    }

    public static boolean judgeSquareSum(int c) {
        int[] arr = new int[c];
        for (int i = 1; i <= c; i++) {
            arr[i - 1] = i;
        }
        int i = 0;
        int j = arr.length - 1;
        while (i <= arr.length - 1 && j >= 0) {
            int i1 = arr[i] * arr[i] + arr[j] * arr[j];
            if (i1 == c) {
                return true;
            } else if (i1 < c) {
                i++;
            } else j--;
        }
        return false;
    }

    public static String reverse(String str) {

        int i = 0;
        int j = str.length() - 1;
        char[] temp = new char[str.length()];
        while (i <= j) {
            Character c = str.charAt(i);
            String s1 = c.toString();
            Character c1 = str.charAt(j);
            String s2 = c1.toString();
            String s = "aeiouAEIOU";
            if (!s.contains(s1)) {
                temp[i++] = c;
            } else if (!s.contains(s2)) {
                temp[j--] = c1;
            } else {
                temp[i++] = c1;
                temp[j--] = c;
            }
        }
        return new String(temp);
    }

    public static boolean test4(String str) {
        int i = -1;
        int j = str.length();
        while (++i < --j) {
            if (str.charAt(i) != str.charAt(j)) {
                return test5(str, i + 1, j) || test5(str, i, j - 1);
            }
        }
        return true;
    }

    public static boolean test5(String str, int i, int j) {
        while (i < j) {
            if (str.charAt(i++) != str.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1, index2 = n - 1;
        int indexMerge = m + n - 1;
        while (index1 >= 0 || index2 >= 0) {
            if (index1 < 0) {
                nums1[indexMerge--] = nums2[index2--];
            } else if (index2 < 0) {
                nums1[indexMerge--] = nums1[index1--];
            } else if (nums1[index1] > nums2[index2]) {
                nums1[indexMerge--] = nums1[index1--];
            } else {
                nums1[indexMerge--] = nums2[index2--];
            }
        }
    }

    public static String findLongestWord(String s, List<String> d) {
        String temp = "";
        for (String s1 : d) {
            if (temp.length() > s1.length() || (temp.length() == s1.length() && temp.compareTo(s1) < 0)) {
                continue;
            } else if (isValid(s, s1)) {
                temp = s1;
            }
        }
        return temp;
    }

    private static boolean isValid(String s, String target) {
        int i = 0, j = 0;
        while (i < s.length() && j < target.length()) {
            if (s.charAt(i) == target.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == target.length();
    }

   public static void strength(int[] arr){
        int tenmp=0;
       for (int i = 0; i <arr.length; i++) {
           if(i<arr.length-1){
               Arrays.sort(arr);
               tenmp += arr[i] + arr[i + 1];
               int s=arr[i] + arr[i + 1];
               arr[i+1]=s;
           }
       }
       System.out.println(tenmp);
   }

    public static void main(String[] args) {
//        int[] ints = twoSum(new int[]{1, 9, 8, 6, 5, 4, 7, 3, 5, 8, 7}, 14);
//        for (int anInt : ints) {
//            System.out.println(anInt);
//        }
        //      System.out.println( judgeSquareSum(5));
//        String leetcode = reverse("hello");
//        System.out.println(leetcode);
//        boolean abcd = test4("abca");
//        System.out.println(abcd)
//        merge(new int[]{0}, 0, new int[]{1}, 1);
//        List list = new ArrayList();
//        list.add("ale");
//        list.add("monkey");
//        list.add("apple");
//        list.add("plea");
//        String abpcplea = findLongestWord("abpcplea", list);
//        System.out.println(abpcplea);
    strength(new int[]{3,1,7,5});
    }
}
