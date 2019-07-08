package StackAndQueue;

import java.util.Deque;
import java.util.LinkedList;

public class StackToQueue {
    public static void main(String[] args) {


    }

   class MyQueue {
        Deque<Integer> in = new LinkedList();
        Deque<Integer> out = new LinkedList();

        void add(Integer o) {
            in.push(o);
        }

        void remove() {
            if (out.isEmpty()) {
                while (in != null) {
                    out.push(in.pop());
                }
            }
            out.pop();
        }
    }
}
