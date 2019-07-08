package StackAndQueue;

public interface QueueTest <T>extends Iterable<T>{

        QueueTest<T> add(T t);
        T remove() throws Exception;
        boolean isEmpty();
        int size();

}
