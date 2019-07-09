/**
 * 二叉树使用递归和非递归实现前中后遍历
 */
package BinaryTree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by lyx on 2019/4/3.
 */
public class Tree implements LinkTree{
    private Node root;

    public Tree() {
    }

    public Tree(Node root) {
        this.root = root;
    }

    @Override
    public boolean isEmpty() {
        return root==null;
    }

    @Override
    public int size() {
        System.out.println("结点的数量");
        return this.size(root);
    }
    private int size(Node root){
        if(root==null){
            return 0;
        }else {
            int nl=this.size(root.leftChild);
            int nr=this.size(root.rightChild);
            return nl+nr+1;
        }
    }

    @Override
    public int getHight() {
        System.out.println("树的高度");
        return this.getHight(root);
    }
    private int getHight(Node root){
        if(root==null) {
            return 0;
        }else {
            int nl = this.getHight(root.leftChild);
            int nr = this.getHight(root.rightChild);
            return nl > nr ? nl+1:nr+1;
        }
    }
    @Override
    public int getNode() {
        return 0;
    }

    @Override
    public Node findKey(int value) {
        System.out.println("查找某个数");
        return this.findKey(value,root);
    }
    private Node findKey(Object value,Node root){
        if(root==null){
            return null;
        }else if(root.value==value&&root!=null){
            return root;
        }else{
            Node node1=this.findKey(value,root.leftChild);
            Node node2=this.findKey(value,root.rightChild);
            if(node1!=null&&node1.value==value){
                return node1;
            }else if(node2!=null&&node2.value==value){
                return node2;
            }else {
                return null;
            }
        }
    }
    @Override
    public void pre() {
    System.out.println("先序遍历");
    this.pre(root);
    System.out.println();
    }
    private void pre(Node root){
        if(root!=null){
            System.out.print(root.value+",");
            this.pre(root.leftChild);
            this.pre(root.rightChild);
        }
    }
    @Override
    public void mid() {
    System.out.println("中序遍历");
    this.mid(root);
    System.out.println();
    }
    private void mid(Node root){
        if(root!=null){
            this.mid(root.leftChild);
            System.out.print(root.value+",");
            this.mid(root.rightChild);
        }
    }
    @Override
    public void aft() {
    System.out.println("后序遍历");
    this.aft(root);
    System.out.println();
    }
    private void aft(Node root){
        if(root!=null) {
            this.aft(root.leftChild);
            this.aft(root.rightChild);
            System.out.print(root.value+",");
        }
    }
    @Override
    public void levelOrderByQueue() {
        System.out.println("层遍历");
    if(root==null)return;
    Queue<Node> queue=new LinkedList<Node>();
    queue.add(root);
    while(queue.size()!=0){
        int len=queue.size();
        for(int i=0;i<len;i++) {
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
    public void midOrderByStack() {
        System.out.println("非递归中序遍历");
    if(root==null)return;
    Deque<Node> stack=new LinkedList<Node>();
    Node current=root;
    while(current!=null||!stack.isEmpty()){
        while(current!=null){
            stack.push(current);
            current=current.leftChild;
        }
        if(!stack.isEmpty()){
            current=stack.pop();
            System.out.print(current.value+",");
            current=current.rightChild;
        }
    }
    System.out.println();
    }

    @Override
    public void preOrderByStack() {
        System.out.println("非递归实现前序遍历");
        if(root==null)return;
        Deque<Node> stack=new LinkedList<Node>();
        Node temp=root;
        while(!stack.isEmpty()||temp!=null){
            if(temp!=null){
                System.out.print(temp.value+",");
                stack.push(temp);
                temp=temp.leftChild;
            }else{
            temp=stack.pop();
            temp=temp.rightChild;
            }
        }
        System.out.println();
    }

    @Override
    public void aftOrderBystack() {
        System.out.println("非递归实现后序遍历");
    Deque<Node> stack=new LinkedList<Node>();
    Deque<Node> output=new LinkedList<Node>();
    Node temp=root;
    while(temp!=null||!stack.isEmpty()){
        if(temp!=null){
           output.push(temp);
            stack.push(temp);
            temp=temp.rightChild;
        }else{
            temp=stack.pop();
            temp=temp.leftChild;
        }
    }
    while(!output.isEmpty()){
        System.out.print(output.pop().value+",");
    }
    System.out.println();
    }
}
