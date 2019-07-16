package cn.lyx.queue;

public interface QueueTest<T> {
    T dequeue();

    void enqueue();

    T peek();

}
