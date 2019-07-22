package cn.lyx.fenzhi;

import java.util.ArrayList;
import java.util.List;

public class BST {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        int n=3;
        List<TreeNode> search = search(1, n);
        for (TreeNode treeNode : search) {
            System.out.println(treeNode.val);
        }
    }

    public static List<TreeNode> search(int start, int end) {
        List<TreeNode> nodes = new ArrayList<>();
        if (start>end) {
            return nodes;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> l = search(start, i - 1);
            List<TreeNode>r = search(i + 1, end);
            for (TreeNode left : l) {
                for (TreeNode right : r) {
                    TreeNode node1=new TreeNode(i);
                    node1.left=left;
                    node1.right=right;
                    nodes.add(node1);
                }
            }
        }
        return nodes;
    }
}
