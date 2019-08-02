package cn.lyx.linkList;

public interface Lists<T> {
    void addAsFirst(T t);
    void addAsLast(T t);
    void remove(T t);
    void update(T t);
    T find();
    int size();
    void  show();
}
