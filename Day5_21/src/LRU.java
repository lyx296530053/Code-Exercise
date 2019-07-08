import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

class Cache extends LinkedHashMap {
    private static final int MAX_ENTRYS = 3;

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > MAX_ENTRYS;
    }

    Cache() {
        super(MAX_ENTRYS, 0.75f, true);
    }
}

public class LRU {
    public static void main(String[] args) {
        Cache cache = new Cache();
        cache.put(1, "a");
        cache.put(2, "b");
        cache.put(3, "c");
        cache.get(1);
        cache.put(4, "d");
        System.out.println(cache.keySet());
        Set set = cache.keySet();
        for (Object o : set) {
            cache.get(o);
        }
    }
}
