package Util;

import java.util.ArrayList;

/**
 * Created by lyx on 2019/4/10.
 */
public class Test {
    public static void main(String[] args){
        ArrayList<Person> arrayList=new ArrayList<Person>();
        arrayList.add(new Person("lyx1",1));
        arrayList.add(new Person("lyx2",2));
        arrayList.add(new Person("lyx3",3));
        arrayList.add(new Person("lyx4",4));
        System.out.println(arrayList.contains(new Person("lyx2",2)));
        arrayList.remove(new Person("lyx2",2));
        for (Person i:arrayList){
            System.out.println(i);
     }

    }
}
