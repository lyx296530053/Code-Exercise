package cn.lyx.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class BST<key extends Comparable<key>, value> implements OrderedST<key, value> {
    protected Node root;

    @Override
    public int size() {
        return this.size(root);
    }

    private int size(Node root) {
        if (root == null) {
            return 0;
        }
        return root.n;
    }


    @Override
    public value get(key key) {
        return this.get(root, key);
    }

    private value get(Node root, key key) {
        if (root == null) {
            return null;
        } else if (root.key == key) {
            return root.value;
        } else {
            int a = key.compareTo(root.key);
            if (a > 0) {
                return get(root.right, key);
            } else {
                return get(root.left, key);
            }
        }
    }

    @Override
    public void put(key key, value value) {
        root = this.put(root, key, value);
    }

    private Node put(Node x, key key, value value) {
        if (x == null)
            return new Node(key, value, 1);
        int cmp = key.compareTo(x.key);
        if (cmp == 0)
            x.value = value;
        else if (cmp < 0)
            x.left = put(x.left, key, value);
        else
            x.right = put(x.right, key, value);
        x.n = size(root.left) + size(root.right) + 1;
        return x;
    }

    @Override
    public key floor(key key) {
        Node floor = this.floor(root, key);
        if(floor==null){
            return null;
        }
        return floor.key;
    }

    private Node floor(Node root, key key) {
        if (root == null) {
            return null;
        }
        int i = key.compareTo(root.key);
        if (i == 0) {
            return root;
        } else if (i < 0) {
            return floor(root.left, key);
        }
        Node floor = floor(root.right, key);
        return floor != null ? floor : root;
    }

    @Override
    public int rank(key key) {
        return 0;
    }

    @Override
    public key min() {
        return null;
    }

    @Override
    public void delete(key key) {
        this.delete(root, key);
    }

    private void delete(Node node, key key) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right != null) {
            node = node.right;
            return;
        } else if (node.right == null && node.left != null) {
            node = node.left;
            return;
        } else {
            delete(node.right, key);
        }
    }

    @Override
    public List<key> keys(key l, key h) {
        return keys(root, l, h);
    }

    private List<key> keys(Node x, key l, key h) {

        List<key> list = new ArrayList<>();
        if (x == null)
            return list;
        int cmpL = l.compareTo(x.key);
        int cmpH = h.compareTo(x.key);
        if (cmpL < 0)
            list.addAll(keys(x.left, l, h));
        if (cmpL <= 0 && cmpH >= 0)
            list.add(x.key);
        if (cmpH > 0)
            list.addAll(keys(x.right, l, h));

        return list;
    }

    public void show() {
        System.out.println(root);
    }

    private class Node {
        Node left;
        Node right;
        key key;
        value value;
        int n;

        public Node(key key, value value, int n) {
            this.key = key;
            this.value = value;
            this.n = n;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "left=" + left +
                    ", right=" + right +
                    ", key=" + key +
                    ", value=" + value +
                    ", n=" + n +
                    '}';
        }
    }

}
