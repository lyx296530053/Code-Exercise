package cn.lyx.BST;

import java.util.ArrayList;
import java.util.List;

public class BstTest<key extends Comparable, value> implements OrderedST<key, value> {
    private class Node {
        Node left;
        Node rigth;
        key key;
        value value;
        int size;

        public Node() {
        }

        public Node(key key, value value) {
            this.value = value;
            this.key = key;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRigth() {
            return rigth;
        }

        public void setRigth(Node rigth) {
            this.rigth = rigth;
        }

        public key getKey() {
            return key;
        }

        public void setKey(key key) {
            this.key = key;
        }

        public value getValue() {
            return value;
        }

        public void setValue(value value) {
            this.value = value;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }
    }

    private Node root;

    @Override
    public int size() {
        return this.size(root);
    }

    private int size(Node root) {
        if (root == null) {
            return 0;
        } else {
            return root.size;
        }
    }

    private int calcucater(Node node) {
        if (node == null) {
            return 0;
        } else {
            return calcucater(node.left) + calcucater(node.rigth) + 1;
        }
    }

    @Override
    public value get(key key) {
        return this.get(root, key);
    }

    private value get(Node node, key key) {
        if (node == null) {
            return null;
        }
        int temp = key.compareTo(node.key);
        if (temp == 0) {
            return node.value;
        }
        if (temp < 0) {
            return get(node.left, key);
        } else {
            return get(node.rigth, key);
        }
    }

    @Override
    public void put(key key, value value) {
        root = put(root, key, value);
    }

    private Node put(Node node, key key, value value) {
        if (node == null) {
            return new Node(key, value);
        }
        int n = key.compareTo(node.key);
        if (n == 0) {
            node.value = value;
        }
        if (n < 0) {
            node.left = put(node.left, key, value);
        } else {
            node.rigth = put(node.rigth, key, value);
        }
        node.size = calcucater(node);
        return node;
    }

    @Override
    public key floor(key key) {
        Node floor = this.floor(root, key);
        if (floor != null) {
            return floor.key;
        }
        return null;
    }

    private Node floor(Node node, key key) {
        if (node == null) {
            return null;
        }
        int n = key.compareTo(node.key);
        if (n == 0) {
            return node;
        }
        if (n < 0) {
            return floor(node.left, key);
        }
        Node floor = floor(node.rigth, key);
        return floor != null ? floor : node;

    }

    @Override
    public int rank(key key) {
        return this.rank(root, key);
    }

    private int rank(Node node, key key) {
        if (node == null) {
            return 0;
        }
        int n = key.compareTo(node.key);
        if (n == 0) {
            return size(node.left);
        } else if (n < 0) {
            return rank(node.left, key);
        } else {
            return 1 + size(root.left) + rank(root.rigth, key);
        }
    }

    @Override
    public key min() {
        return this.min(root).key;
    }

    private Node min(Node node) {
        if (node == null) {
            return null;
        }
        if (node.left == null) {
            return node;
        }
        return min(node.left);
    }

    @Override
    public void deleteMin() {
        root = this.deleteMin(root);
    }

    private Node deleteMin(Node node) {
        if (node.left == null) {
            return node.rigth;
        }
        node.left = deleteMin(node.left);
        calcucater(node);
        return node;
    }

    @Override
    public void delete(key key) {
        root = this.delete(root, key);
    }

    private Node delete(Node node, key key) {
        if (node == null) {
            return null;
        }
        int temp = key.compareTo(node.key);
        if (temp < 0) {
            root.left = delete(root.left, key);
        }
        if (temp > 0) {
            root.rigth = delete(root.rigth, key);
        }
        if (node.left == null) {
            return root.rigth;
        }
        if (node.rigth == null) {
            return root.left;
        }
        Node t = node;
        t = min(node.rigth);
        t.rigth = deleteMin(node);
        t.left = node.left;
        t.size = calcucater(t);
        return t;
    }

    @Override
    public List<key> keys(key key, key key1) {
        return this.keys(root, key, key1);
    }

    private List<key> keys(Node node, key key, key key1) {
        List list = new ArrayList();
        if (node == null) {
            return list;
        }
        int temp = key.compareTo(node.key);
        int temp1 = key1.compareTo(node.key);
        if (temp < 0) {
            list.addAll(keys(node.left, key, key1));
        }
        if (temp <= 0 && temp1 >= 0) {
            list.add(node.key);
        }
        if (temp1 > 0) {
            list.addAll(keys(node.rigth, key, key1));
        }
        return list;
    }
}
