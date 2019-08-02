package cn.lyx.tree;

import java.util.List;

public interface OrderedST<key ,value> {

    int size();//节点数量

    value get(key key);//查找key

    void put(key key, value value);

    key floor(key key);//小于等于键的最大键

    int rank(key key);//查找key的排名

    key min();//查找最小的key

    void delete(key key);//删除任意键
    void deleteMin();//删除最小的key

    List<key> keys(key key, key key1);//查询key-key1
}
