package cn.lyx.BST;

import java.util.ArrayList;
import java.util.List;

public class MyBST<key extends Comparable, value> implements OrderedST<key, value> {
    protected Node root;

    protected class Node {
        key key;
        Node left;
        value value;
        Node right;
        int size;

        public Node(key key, value value, int i) {
            this.key = key;
            this.value = value;
            this.size = i;
        }

        public int getLeftHeight() {
            if (left == null) {
                return 0;
            } else {
                return left.getHeight();
            }
        }

        public int getRightHeight() {
            if (right == null) {
                return 0;
            } else {
                return right.getHeight();
            }
        }

        public int getHeight() {
            return Math.max(this.left == null ? 0 : this.left.getHeight(), this.right == null ? 0 : this.right.getHeight()) + 1;
        }

        public void leftRotate() {
            Node temp = new Node(key, value, 1);
            temp.left = left;
            temp.right = right.left;
            key = right.key;
            value = right.value;
            right = right.right;
            left = temp;
        }

        public void rightRotate() {
            Node temp = new Node(key, value, 1);
            temp.right = right;
            temp.left = left.right;
            key = left.key;
            value = left.value;
            left = left.left;
            right = temp;
        }
    }

    public Node getRoot() {
        return root;
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(Node root) {
        if (root != null) {
            return root.size;
        } else return 0;
    }

    private void calculateSize(Node root) {
        root.size = size(root.right) + size(root.left) + 1;
    }

    @Override
    public value get(key key) {
        return get(root, key);
    }

    private value get(Node root, key key) {
        if (root == null) {
            return null;
        }
        int i = key.compareTo(root.key);
        if (i == 0) {
            return root.value;
        } else if (i > 0) {
            return get(root.left, key);
        } else {
            return get(root.right, key);
        }
    }

    @Override
    public void put(key key, value value) {
        root = put(root, key, value);
    }

    private Node put(Node x, key key, value value) {
        if (x == null) return new Node(key, value, 1);
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            x.value = value;
        } else if (cmp < 0) {
            x.left = put(x.left, key, value);
        } else {
            x.right = put(x.right, key, value);
        }
        if (root.getRightHeight() - root.getLeftHeight() > 1) {
            if (root.right != null && root.right.getLeftHeight() > root.right.getRightHeight()) {
                root.right.rightRotate();
                root.leftRotate();
            } else root.leftRotate();
        } else if (root.getLeftHeight() - root.getRightHeight() > 1) {
            if (root.left != null && root.left.getRightHeight() > root.left.getLeftHeight()) {
                root.left.leftRotate();
                root.rightRotate();
            } else root.rightRotate();
        }
        calculateSize(root);
        return root;
    }


    private void rightRotate(Node root) {
        Node temp = root;
        temp.right = root.right;
        temp.left = root.left.right;
        root = root.left;
        Node temp1 = root.left.left;
        root.left = temp1;
        root.right = temp;

    }

    /**
     * 查找小于等于键的最大键
     *
     * @param
     * @return
     */
    @Override
    public key floor(key key) {
        Node floor = floor(root, key);
        if (floor == root) {
            return null;
        } else {
            return floor.key;
        }
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
        } else {
            Node floor = floor(root.right, key);
            return floor == null ? root : floor;
        }
    }

    /**
     * 返回key的排名
     *
     * @param key
     * @return
     */
    @Override
    public int rank(key key) {
        return rank(root, key);
    }

    private int rank(Node root, key key) {
        if (root == null) {
            return 0;
        }
        int i = key.compareTo(root.key);
        if (i == 0) {
            return size(root.left);
        } else if (i < 0) {
            return rank(root.left, key);
        } else {
            return 1 + size(root.left) + rank(root.right, key);
        }
    }

    /**
     * 查找最小键
     *
     * @return
     */
    @Override
    public key min() {
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

    /**
     * 删除最小键
     */
    @Override
    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node root) {
        if (root.left == null) {
            return root.right;
        }
        root.left = deleteMin(root.left);
        calculateSize(root);
        return root;
    }

    /**
     * 删除键
     *
     * @param key
     */
    @Override
    public void delete(key key) {
        root = delete(root, key);
    }

    private Node delete(Node root, key key) {
        if (root == null) {
            return null;
        }
        int i = key.compareTo(root.key);
        if (i < 0) {
            root.left = delete(root.left, key);
        } else if (i > 0) {
            root.right = delete(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                Node t = root;
                root = min(root.right);
                deleteMin(root.right);
                root.left = t.left;
            }
        }
        calculateSize(root);
        return root;
    }

    /**
     * 返回l到h之间所有键
     *
     * @param l
     * @param h
     * @return
     */
    @Override
    public List<key> keys(key l, key h) {
        return keys(root, l, h);
    }

    private List<key> keys(Node root, key l, key h) {
        List<key> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        int i = l.compareTo(root.key);
        int i1 = h.compareTo(root.key);
        if (i < 0) {
            list.addAll(keys(root.left, l, h));
        }
        if (i <= 0 && i1 >= 0) {
            list.add(root.key);
        }
        if (i1 > 0) {
            list.addAll(keys(root.right, l, h));
        }
        return list;
    }

    public void mid() {
        mid(root);
        System.out.println();
    }

    private void mid(Node root) {
        if (root != null) {
            mid(root.left);
            System.out.print(root.key + " ");
            mid(root.right);
        }
    }
}
