package cn.lyx.queue;

public interface MyQueue<Item> extends Iterable {
    int size();

    boolean isEmpty();

    MyQueue<Item> add(Item item);

    Item remove() throws Exception;
}
