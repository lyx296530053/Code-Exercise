package cn.lyx.Collection;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K,V> extends LinkedHashMap {
    private static final int MAX_CACHE=3;

    public LRUCache() {
        super(3,0.75f,true);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size()>MAX_CACHE;
    }
}
