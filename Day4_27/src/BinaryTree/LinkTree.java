package BinaryTree;

/**
 * Created by lyx on 2019/4/3.
 */
public interface LinkTree {
    boolean isEmpty();
    int size();
    int getHight();
    int getNode();
    Node findKey(int value);
    void pre();
    void mid();
    void aft();
    void levelOrderByQueue();
    void preOrderByStack();
    void midOrderByStack();
    void aftOrderBystack();
}
