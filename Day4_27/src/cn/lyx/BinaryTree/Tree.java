package BinaryTree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Tree implements LinkTree {
    private Node root;

    public Tree(Node root) {
        this.root = root;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int size() {
        return this.size(root);
    }

    private int size(Node root) {
        if (root != null) {
            int left = size(root.leftChild);
            int rignt = size(root.rightChild);
            return left + rignt + 1;
        } else {
            return 0;
        }
    }

    @Override
    public int getHight() {
        return this.getHight(root);
    }

    private int getHight(Node root) {
        if (root != null) {
            int left = size(root.leftChild);
            int rignt = size(root.rightChild);
            return left > rignt ? left + 1 : rignt + 1;
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
        return this.findKey(root, value);
    }

    private Node findKey(Node root, Object value) {
        if(root==null){
            return null;
        }
        if (root != null && root.value == value) {
            return root;
        } else {
            Node leftChild = this.findKey(root.leftChild, value);
            Node rightChild = this.findKey(root.rightChild, value);
            if (leftChild != null && leftChild.value == value) {
                return leftChild;
            } else if (rightChild != null && rightChild.value == value) {
                return rightChild;
            } else {
                return null;
            }
        }
    }

    @Override
    public void pre() {
this.pre(root);
        System.out.println();
    }
private void pre(Node root){
        if(root!=null) {
            System.out.print(root.value + " ");
            this.pre(root.leftChild);
            this.pre(root.rightChild);
        }
}
    @Override
    public void mid() {

    }

    @Override
    public void aft() {

    }

    @Override
    public void levelOrderByQueue() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                Node temp = queue.poll();
                System.out.print(temp.value + ",");
                if (temp.leftChild != null) {
                    queue.add(temp.leftChild);
                }
                if (temp.rightChild != null) {
                    queue.add(temp.rightChild);
                }
            }
        }
        System.out.println();
    }

    @Override
    public void preOrderByStack() {
        Deque<Node> deque = new LinkedList<>();
        Node temp = root;
        while (!deque.isEmpty() || temp != null) {
            if (temp != null) {
                System.out.print(temp.value + ",");
                deque.push(temp);
                temp = temp.leftChild;
            } else {
                temp = deque.pop();
                temp = temp.rightChild;
            }
        }
        System.out.println();
    }

    @Override
    public void midOrderByStack() {
        Deque<Node> deque = new LinkedList<>();
        Node temp = root;
        while (!deque.isEmpty() || temp != null) {
            if (temp != null) {
                deque.push(temp);
                temp = temp.leftChild;
            } else {
                temp = deque.pop();
                System.out.print(temp.value + ",");
                temp = temp.rightChild;
            }
        }
        System.out.println();
    }

    @Override
    public void aftOrderBystack() {
        Deque<Node> deque = new LinkedList<>();
        Deque<Node> arr = new LinkedList<>();
        Node temp = root;
        while (!deque.isEmpty() || temp != null) {
            if (temp != null) {
                deque.push(temp);
                arr.push(temp);
                temp = temp.rightChild;
            } else {
                temp = deque.pop();
                temp = temp.leftChild;
            }
        }
        while (!arr.isEmpty()) {
            System.out.print(arr.pop().value + ",");
        }
    }
}
