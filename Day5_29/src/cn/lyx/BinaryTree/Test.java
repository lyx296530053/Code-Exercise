package cn.lyx.BinaryTree;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        OrderedST<String,Object> ordered=new BST<>();
        ordered.put("a",3);
        ordered.put("b",2);
        ordered.put("e",4);
        ordered.put("c",10);
        ordered.put("a",8);
        System.out.println(ordered.size());
        ordered.delete("b");
        List<String> keys = ordered.keys("a","d");
        for (String key : keys) {
            System.out.println(key);
        }
    }
}
