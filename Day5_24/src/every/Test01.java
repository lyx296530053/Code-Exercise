package every;

import java.util.Stack;

public class Test01 {
    public static void main(String[] args) {
    queue q=new queue();
   q.push('s'  );
   q.push(2);
   q.push(3);
     q.push(5);
        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.pop());

    }

   static class queue {
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();
        int size;
        public  void push(int node) {
            stack1.push(node);
            size++;
        }
        public int pop() {
            if(size>0) {
                while (size-- > 0) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }
    }
}
