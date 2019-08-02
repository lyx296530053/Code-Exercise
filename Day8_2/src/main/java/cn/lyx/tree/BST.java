package cn.lyx.tree;

import java.util.ArrayList;
import java.util.List;

public class BST<Key extends Comparable<Key>, Value> implements OrderedST<Key, Value> {
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
        } else
            root.left = put(root.left, key, value);

        calculateSIze(root);
        return root;

    }

    public void mid() {
        mid(root);
        System.out.println();
    }

    private void mid(Node root) {
        if (root != null) {
            mid(root.left);
            System.out.print(root.val + " ");
            mid(root.right);
        }

    }

    @Override
    public Key floor(Key key) {
        return floor(key, root);
    }

    private Key floor(Key key, Node root) {
        if (root == null) {
            return null;
        }
        int i = key.compareTo(root.key);
        if (i == 0) {
            return root.key;
        } else if (i < 0) {
            return floor(key, root.left);
        } else {
            Key floor = floor(key, root.right);
            return floor == null ? root.key : floor;
        }

    }

    @Override
    public int rank(Key key) {
        return rank(key, root);
    }

    private int rank(Key key, Node root) {
        if (root == null) {
            return 0;
        }
        int i = key.compareTo(root.key);
        if (i == 0) {
            return size(root.left) + 1;
        }
        if (i < 0) {
            return rank(key, root.left) + 1;
        } else
            return 1 + size(root.left) + rank(key, root.right);
    }

    @Override
    public Key min() {
        return min(root).key;
    }

    private Node min(Node root) {
        if (root == null) {
            return null;
        }
        if (root.left == null) {
            return root;
        }
        return min(root.left);
    }

    @Override
    public void delete(Key key) {
        root = delete(key, root);
    }

    private Node delete(Key key, Node root) {
        if (root == null) {
            return root;
        }
        int i = key.compareTo(root.key);
        if (i < 0) {
            root.left = delete(key, root.left);
        } else if (i > 0) {
            root.right = delete(key, root.right);
        } else {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            Node temp = root;
            root = min(temp.right);
            root.right = deleteMin(temp.right);
            root.left = temp.left;
        }
        calculateSIze(root);
        return root;
    }

    @Override
    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node root) {
        if (root == null) {
            return null;
        }
        if (root.left == null) {
            return root.right;
        }
        root.left = deleteMin(root.left);
        calculateSIze(root);
        return root;
    }

    @Override
    public List<Key> keys(Key key, Key key1) {
        return keys(root, key, key1);
    }

    private List<Key> keys(Node root, Key key, Key key1) {

        List<Key> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        int lt = key.compareTo(root.key);
        int gt = key1.compareTo(root.key);
        if (lt < 0) {
            list.addAll(keys(root.left, key, key1));
        }
        if (lt <= 0 && gt >= 0) {
            list.add(root.key);
        }
        if (gt > 0) {
            list.addAll(keys(root.right, key, key1));
        }
        return list;
    }
}
