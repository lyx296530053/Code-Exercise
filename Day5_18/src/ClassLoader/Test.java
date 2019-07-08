package ClassLoader;

import java.util.LinkedHashMap;
import java.util.Map;

class Lru   extends LinkedHashMap{
    private static final int a=3;

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size()>a;
    }
    Lru(){
        super(a,0.75f,true);
    }
}
public class Test {
    public static void main(String[] args) {
    Lru lru=new Lru();
    lru.put(1,"a");
    lru.put(2,"b");
    lru.put(3,"c");
    lru.get(1);
    lru.put(4,"d");
        System.out.println(lru.keySet());
    }
}
