package cn.lyx.BST;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        OrderedST<String,Object> ord=new BstTest<>();
        ord.put("a",8);
        ord.put("b",9);
        ord.put("c",7);
        ord.put("d",3);
        ord.put("e",2);
        System.out.println(ord.size());
        System.out.println(ord.get("d"));
        String g = ord.floor("b");
        System.out.println(g);
        System.out.println(ord.rank("a"));
        System.out.println(ord.min());
        ord.deleteMin();
        System.out.println(ord.get("a"));
        List<String> keys = ord.keys("a", "c");
        for (String key : keys) {
            System.out.println(key);
        }
        ord.delete("b");
        System.out.println(ord.get("b"));
    }
}
