package cn.lyx.tree;

import cn.lyx.tree.BST;
import cn.lyx.tree.OrderedST;

import java.util.List;

public class AVL<Key extends Comparable<Key>, Value> implements OrderedST<Key, Value> {
    class Node {
        Key key;
        Value val;
        Node left;
        Node right; // 以该节点为根的子树节点总数
        int N;

        public Node(Key key, Value value, int i) {
            this.key = key;
            this.val = value;
            this.N = i;
        }
    }

    private Node root;

    public int getHeight() {
        return getHeight(root);
    }

    private int getHeight(Node root) {
        if (root != null) {
            int left = getHeight(root.left);
            int right = getHeight(root.right);
            return left > right ? left + 1 : right + 1;
        }
        return 0;
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(Node root) {
        if (root == null) {
            return 0;
        }
        return root.N;
    }

    protected void calculateSIze(Node root) {
        root.N = size(root.left) + size(root.right) + 1;
    }

    @Override
    public Value get(Key key) {
        return get(key, root);
    }

    private Value get(Key key, Node root) {
        if (root == null) {
            return null;
        }
        int i = key.compareTo(root.key);
        if (i == 0) {
            return root.val;
        }
        if (i > 0) {
            return get(key, root.right);
        } else {
            return get(key, root.left);
        }
    }

    @Override
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node root, Key key, Value value) {
        if (root == null) {
            return new Node(key, value, 1);
        }
        int i = key.compareTo(root.key);
        if (i == 0) {
            root.val = value;
        } else if (i > 0) {
            root.right = put(root.right, key, value);
        } else {
            root.left = put(root.left, key, value);
        }
        if (getHeight(root.right) - getHeight(root.left) > 1) {
            if (getHeight(root.right.left) > getHeight(root.right.right)) {
                rigthtRevolve(root.right);
            }
            leftRevolve(root);
        } else if (getHeight(root.left) - getHeight(root.right) > 1) {
            if (getHeight(root.left.right) > getHeight(root.left.left)) {
                leftRevolve(root.left);
            }
            rigthtRevolve(root);
        }
        calculateSIze(root);
        return root;
    }

    private void leftRevolve(Node node) {
        Node temp = new Node(node.key, node.val, node.N);
        temp.left = node.left;
        temp.right = node.right.left;
        node.val = node.right.val;
        node.right = node.right.right;
        node.left = temp;
    }

    private void rigthtRevolve(Node node) {
        Node temp = new Node(node.key, node.val, node.N);
        temp.right = node.right;
        temp.left = node.left.right;
        node.val = node.left.val;
        node.left = node.left.left;
        node.right = temp;
    }

    @Override
    public Key floor(Key key) {
        return null;
    }

    @Override
    public int rank(Key key) {
        return 0;
    }

    @Override
    public Key min() {
        return null;
    }

    @Override
    public void delete(Key key) {

    }

    @Override
    public void deleteMin() {

    }

    @Override
    public List<Key> keys(Key key, Key key1) {
        return null;
    }
}
