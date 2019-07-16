package cn.lyx.BinaryThree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Tree implements LinkTree {
    Node root;

    public Tree(Node root) {
        this.root = root;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(Node root) {
        if (root != null) {
            int left = size(root.leftChild);
            int right = size(root.rightChild);
            return left + right + 1;
        } else {
            return 0;
        }
    }

    @Override
    public int getHight() {
        return getHight(root);
    }

    private int getHight(Node root) {
        if (root != null) {
            int left = getHight(root.leftChild);
            int right = getHight(root.rightChild);
            return left > right ? left + 1 : right + 1;
        } else {
            return 0;
        }
    }

    @Override
    public int getNode() {
        return 0;
    }

    @Override
    public Node findKey(int value) {
        return findKey(root, value);
    }

    private Node findKey(Node root, Object value) {
        if (root == null) {
            return null;
        }
        if (root != null && root.value == value) {
            return root;
        } else {
            Node left = findKey(root.leftChild, value);
            Node right = findKey(root.rightChild, value);
            if (left != null && left.value == value) {
                return left;
            } else if (right != null && right.value == value) {
                return right;
            } else return null;
        }
    }

    @Override
    public void pre() {
        pre(root);
        System.out.println();
    }

    private void pre(Node root) {
        if (root != null) {
            System.out.print(root.value + " ");
            pre(root.leftChild);
            pre(root.rightChild);
        }
    }

    @Override
    public void mid() {
        mid(root);
        System.out.println();
    }

    private void mid(Node root) {
        if (root != null) {
            mid(root.leftChild);
            System.out.print(root.value + " ");
            mid(root.rightChild);
        }
    }

    @Override
    public void aft() {
        aft(root);
        System.out.println();
    }

    private void aft(Node root) {
        if (root != null) {
            aft(root.leftChild);
            aft(root.rightChild);
            System.out.print(root.value + " ");
        }
    }

    @Override
    public void levelOrderByQueue() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() != 0) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                Node poll = queue.poll();
                System.out.print(poll.value + " ");
                if (poll.leftChild != null) {
                    queue.add(poll.leftChild);
                }
                if (poll.rightChild != null) {
                    queue.add(poll.rightChild);
                }
            }
        }
        System.out.println();
    }

    @Override
    public void preOrderByStack() {
        Deque<Node> stack = new LinkedList<>();
        Node temp = root;
        while (!stack.isEmpty() || temp != null) {
            if (temp != null) {
                System.out.print(temp.value + " ");
                stack.push(temp);
                temp = temp.leftChild;
            } else {
                temp = stack.pop();
                temp = temp.rightChild;
            }
        }
        System.out.println();
    }

    @Override
    public void midOrderByStack() {
        Deque<Node> stack = new LinkedList<>();
        Node temp = root;
        while (!stack.isEmpty() || temp != null) {
            if (temp != null) {
                stack.push(temp);
                temp = temp.leftChild;
            } else {
                temp = stack.pop();
                System.out.print(temp.value + " ");
                temp = temp.rightChild;
            }
        }
        System.out.println();
    }

    @Override
    public void aftOrderBystack() {
        Deque<Node> stack = new LinkedList<>();
        Deque<Node> nodes = new LinkedList<>();
        Node temp = root;
        while (!stack.isEmpty() || temp != null) {
            if (temp != null) {
                stack.push(temp);
                nodes.push(temp);
                temp = temp.rightChild;
            } else {
                temp = stack.pop();
                temp = temp.leftChild;
            }
        }
        while (!nodes.isEmpty()) {
            System.out.print(nodes.pop().value + " ");
        }
    }
}
