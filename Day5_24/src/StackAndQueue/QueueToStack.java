package StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

class MyStack1 {
    private Queue<Integer> q=new LinkedList<>();
    void push(int a){
        q.add(a);
        int size=q.size();
        while (--size>1){
            q.add(q.poll());
        }
    }
    int pop(){
        return q.remove();
    }
}
public class QueueToStack {
    public static void main(String[] args) {

    }
}
