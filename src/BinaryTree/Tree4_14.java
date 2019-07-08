package BinaryTree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by lyx on 2019/4/14.
 */
public class Tree4_14 implements LinkTree{
    private Node root;

    public Tree4_14(Node root) {
        this.root = root;
    }

    public Tree4_14() {

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
        if(root!=null){
            int lt=this.size(root.leftChild);
            int rt=this.size(root.rightChild);
            return lt+rt+1;
        }else {
            return 0;
        }
    }
    @Override
    public int getHight() {
        System.out.println("树的高度");
        return this.getHight(root);
    }
    private int getHight(Node root){
        if(root==null){
            return 0;
        }else{
            int lt=this.getHight(root.leftChild);
            int rt=this.getHight(root.rightChild);
            return lt>rt?lt+1:rt+1;
        }
    }
    @Override
    public int getNode() {
        return 0;
    }

    @Override
    public Node findKey(int value) {
        System.out.println("查找某个元素");
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
    System.out.println("递归实现前序遍历");
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
    System.out.println("递归实现中序遍历");
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
    System.out.println("递归实现后序遍历");
    this.aft(root);
    System.out.println();
    }
    private void aft(Node root){
        if(root!=null){
            this.aft(root.leftChild);
            this.aft(root.rightChild);
            System.out.print(root.value+",");
        }
    }
    @Override
    public void levelOrderByQueue() {
        System.out.println("层遍历");
        Queue<Node> queue=new LinkedList<Node>();
        queue.add(root);
        while(queue.size()!=0){
            int n=queue.size();
            for(int i=0;i<n;i++){
                Node temp=queue.poll();
                System.out.print(temp.value+",");
                if(temp.leftChild!=null){
                    queue.add(temp.leftChild);
                }
                if(temp.rightChild!=null){
                    queue.add(temp.rightChild);
                }
            }
        }
    System.out.println();
    }

    @Override
    public void preOrderByStack() {
    if(root==null)return;
    Deque<Node> deque=new LinkedList<>();
    Node temp=root;
    while(temp!=null||deque.size()>0){
        if(temp!=null){
            System.out.print(temp.value+",");
            deque.push(temp);
            temp=temp.leftChild;
        }else {
            temp=deque.pop();
            temp=temp.rightChild;
        }
    }
    System.out.println();
    }

    @Override
    public void midOrderByStack() {
    if(root==null)return;
    Deque<Node> deque=new LinkedList<>();
    Node temp=root;
    while (temp!=null||deque.size()>0){
        if(temp!=null){
            deque.push(temp);
            temp=temp.leftChild;
        }else {
            temp=deque.pop();
            System.out.print(temp.value+",");
            temp=temp.rightChild;
        }
    }
    System.out.println();
    }

    @Override
    public void aftOrderBystack() {
    if(root==null)return;
    Deque<Node> deque=new LinkedList<>();
    Deque<Node> newDeque=new LinkedList<>();
    Node temp=root;
    while(temp!=null||!deque.isEmpty()){
        if(temp!=null){
            deque.push(temp);
            newDeque.push(temp);
            temp=temp.rightChild;
        }else {
            temp=deque.pop();
            temp=temp.leftChild;
        }
      while (!newDeque.isEmpty()){
            System.out.print(newDeque.pop().value);
      }
    }
    System.out.println();
    }
}
