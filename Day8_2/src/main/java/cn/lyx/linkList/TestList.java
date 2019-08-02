package cn.lyx.linkList;

import org.junit.Test;

public class TestList {
    @Test
    public void test(){
//        SingleLinkList singleLinkList=new SingleLinkList();
//        singleLinkList.addAsLast(1);
//        singleLinkList.addAsLast(2);
//        singleLinkList.addAsLast(3);
//        singleLinkList.show();
//        singleLinkList.reverse();
//        singleLinkList.show();
        //System.out.println(singleLinkList.size());
        MyLinkedList myLinkedList=new MyLinkedList();
        myLinkedList.addAsFirst(1);
        myLinkedList.addAsFirst(2);
        myLinkedList.addAsFirst(3);
        myLinkedList.show();
        myLinkedList.remove(2);
        myLinkedList.show();
    }
}
