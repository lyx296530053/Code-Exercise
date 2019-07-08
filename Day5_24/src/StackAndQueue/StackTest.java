package StackAndQueue;

public interface StackTest <T> extends Iterable<T> {
    StackTest<T> push(T t);
    T pop() throws Exception;
    boolean isEmpty();
    int size();
}
