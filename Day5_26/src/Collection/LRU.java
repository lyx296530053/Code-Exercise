package Collection;

import java.util.LinkedHashMap;
import java.util.Map;

class MyCache<K, V> extends LinkedHashMap<K, V> {
    private static final int size = 3;

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > size;
    }

    MyCache() {
        super(size, 0.75f, true);
    }
}

public class LRU {
    public static void main(String[] args) {
        MyCache<String, Integer> myCache = new MyCache();
        myCache.put("a", 1);
        myCache.put("b", 2);
        myCache.put("c", 3);
        myCache.get("b");
        myCache.put("d", 4);
        System.out.println(myCache.keySet());
    }
}
