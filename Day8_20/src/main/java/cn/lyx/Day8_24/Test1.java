package cn.lyx.Day8_24;

import javax.swing.tree.TreeNode;
import java.util.*;


class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

class Solution {
    public RandomListNode Clone(RandomListNode head) {
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode temp = head;
        while (temp != null) {
            map.put(temp, new RandomListNode(temp.label));
            temp = temp.next;
        }
        temp = head;

        while (temp != null) {
            map.get(temp).next = map.get(temp.next);
            map.get(temp).random = map.get(temp.random);
            temp = temp.next;
        }
        return map.get(head);

    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    TreeNode pre = null;
    TreeNode next = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        Convert(pRootOfTree.left);

        if (pre == null) {
            next = pre = pRootOfTree;
        } else {
            next.left = pRootOfTree;
            pRootOfTree.right = next.right;
            next = pRootOfTree;
        }
        Convert(pRootOfTree.right);
        return pre;
    }

    public static void test1() {
        String string = "fadsdadffg";
        char[] chars = string.toCharArray();
        Arrays.sort(chars);

    }
class compa implements Comparator<Character>{


    @Override
    public int compare(Character o1, Character o2) {
        return o1-o2;
    }
}


    public static ArrayList<String> Permutation(String str){

        ArrayList<String> list = new ArrayList<String>();
        if(str!=null && str.length()>0){
            PermutationHelper(str.toCharArray(),0,list);
            Collections.sort(list);
        }
        return list;
    }
    private static void PermutationHelper(char[] chars,int i,ArrayList<String> list){
        if(i == chars.length-1){
            list.add(String.valueOf(chars));
        }else{
            Set<Character> charSet = new HashSet<Character>();
            for(int j=i;j<chars.length;++j){
                if(j==i || !charSet.contains(chars[j])){
                    charSet.add(chars[j]);
                    swap(chars,i,j);
                    PermutationHelper(chars,i+1,list);
                    swap(chars,j,i);
                }
            }
        }
    }

    private  static  void swap(char[] cs,int i,int j){
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }
    public static void main(String[] args) {
        ArrayList<String> abc = Permutation("abc");
        for (String string : abc) {
            System.out.println(string);
        }
    }
}