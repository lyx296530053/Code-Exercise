package Collection;

import java.util.Iterator;
import java.util.TreeSet;
class  tom {
    private String name;
    private Integer age;

    public tom(String name, Integer age) {
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


//    @Override
//    public int compareTo(tom o) {
//
//            return this.name.compareTo(o.name);
//        }

    @Override
    public String toString() {
        return "tom{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
public class TreeSetTest {
    public static void main(String[] args){
        Comparable comparable=new Comparable() {
            @Override
            public int compareTo(Object o) {
                return 0;
            }
        };
        TreeSet set=new TreeSet();
        set.add(new tom("ccc",111));
        set.add(new tom("bbb",222));
        set.add(new tom("aaa",333));
        Iterator iterator=set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
