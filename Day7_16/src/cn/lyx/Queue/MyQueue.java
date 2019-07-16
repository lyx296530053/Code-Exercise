package cn.lyx.Queue;

public interface MyQueue<T> extends Iterable<T> {
    int size();

    boolean isEmpty();

    MyQueue<T> add(T t);

    T remove() throws Exception;
}
