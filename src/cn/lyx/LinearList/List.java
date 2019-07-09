package LinearList;

/**
 * Created by lyx on 2019/4/2.
 */
public interface List<T> {
    void add(T t);
    void add(int n,T t);
    void remove(int t);
    int size();
    void show();
}
