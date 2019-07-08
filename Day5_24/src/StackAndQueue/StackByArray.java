package StackAndQueue;


import java.util.Iterator;

class MyStack<T> implements StackTest<T> {
    private T[] arr = (T[]) new Object[1];
    private int size=0;

    @Override
    public StackTest<T> push(T t) {
        check();
        arr[size++] = t;
        return this;
    }

    private void check() {
        if (size >= arr.length) {
            resize(arr.length * 2);
        } else if (size > 0 && size <= (arr.length / 4)) {
            resize(arr.length / 2);
        }
    }

    private void resize(int i) {
        T[] t = (T[]) new Object[i];
        for (int j = 0; j < size; j++) {
            t[j] = arr[j];
        }
        arr = t;
    }

    @Override
    public T pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("Stack is null");
        }
        T t = arr[--size];
        check();
        arr[size] = null;
        return t;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int i = size;

            @Override
            public boolean hasNext() {
                return i > 0;
            }

            @Override
            public T next() {
                return arr[--i];
            }
        };
    }
}

public class StackByArray {
    public static void main(String[] args) throws Exception {
        StackTest<Integer> stackTest = new MyStack<>();
        stackTest.push(1);
        stackTest.push(2);
        stackTest.push(3);
        stackTest.push(4);
        System.out.println(stackTest.size());
        Iterator<Integer> iterator = stackTest.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next());
        }
        stackTest.pop();
        stackTest.pop();
        Iterator<Integer> iterator1 = stackTest.iterator();
        while(iterator1.hasNext()){
            System.out.print(iterator1.next());
        }
    }
}
