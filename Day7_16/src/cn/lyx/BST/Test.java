package cn.lyx.BST;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        MyBST<String,Object> bst=new MyBST();
        bst.put("a",1);
        bst.put("b",2);
        bst.put("c",3);
        bst.put("d",4);
        System.out.println(bst.get("b"));
        System.out.println(bst.get("d"));
        System.out.println(bst.size());
        System.out.println(bst.rank("d"));
        System.out.println(bst.min());
        bst.deleteMin();
        System.out.println(bst.get("a"));
        bst.deleteMin();
        System.out.println(bst.get("b"));
        System.out.println(bst.size());
        List<String> keys = bst.keys("a", "d");
        for (String key : keys) {
            System.out.println(key);
        }
    }
}
