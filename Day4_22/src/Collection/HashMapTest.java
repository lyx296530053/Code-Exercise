package Collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class jerry{
    private String name;
    private Integer age;

    public jerry(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "jerry{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        jerry jerry = (jerry) o;

        if (name != null ? !name.equals(jerry.name) : jerry.name != null) return false;
        return age != null ? age.equals(jerry.age) : jerry.age == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (age != null ? age.hashCode() : 0);
        return result;
    }
}
public class HashMapTest {
    public static void main(String[] args) {
        HashMap hashMap=new HashMap();
        hashMap.put(new jerry("aaa",123),666);
        hashMap.put(new jerry("aaa",123),777);
        hashMap.put(new jerry("aaa",123),888);
        Set set = hashMap.entrySet();
        Iterator<Map.Entry> iterator = set.iterator();
        while(iterator.hasNext()){
            Map.Entry next = iterator.next();
            System.out.println(next.getKey()+"--"+next.getValue());
        }
    }
}
