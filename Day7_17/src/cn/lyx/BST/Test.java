package cn.lyx.BST;

public class Test {
    public static void main(String[] args) {
        MyBST<Integer,Object> bst=new MyBST();
        bst.put(10,1);
        bst.put(11,2);
        bst.put(7,3);
        bst.put(6,4);
        bst.put(8,6);
        bst.put(9,7);
//        System.out.println(bst.get("b"));
//        System.out.println(bst.get("d"));
//        System.out.println(bst.size());
//        System.out.println(bst.rank("d"));
//        System.out.println(bst.min());
//        bst.deleteMin();
//        System.out.println(bst.get("a"));
//        bst.deleteMin();
//        System.out.println(bst.get("b"));
//        System.out.println(bst.size());
//        List<String> keys = bst.keys("a", "d");
//        for (String key : keys) {
//            System.out.println(key);
//        }
        System.out.println(bst.getRoot().getHeight());
        System.out.println(bst.getRoot().getLeftHeight());
        System.out.println(bst.getRoot().getRightHeight());
        bst.mid();
    }
}
