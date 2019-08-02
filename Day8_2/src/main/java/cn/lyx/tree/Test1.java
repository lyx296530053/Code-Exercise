package cn.lyx.tree;

import org.junit.Test;

import java.util.Iterator;
import java.util.List;

public class Test1 {
    @Test
    public void test() {
        AVL avl = new AVL<>();
        avl.put("j", 1);
        avl.put("k", 2);
        avl.put("g", 4);
        avl.put("f", 3);
        avl.put("h", 7);
        avl.put("i", 8);
       System.out.println(avl.getHeight());
    }
}
