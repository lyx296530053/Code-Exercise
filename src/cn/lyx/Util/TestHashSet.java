package Util;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
/**
 * Created by lyx on 2019/4/10.
 */
public class TestHashSet {
	public static void main(String[] args){
		Set<Person> hashSet=new HashSet<Person>();
		hashSet.add(new Person("lyx8",2));
		hashSet.add(new Person("lyx2",2));
		hashSet.add(new Person("lyx2",2));
		hashSet.add(new Person("lyx4",4));
		hashSet.add(new Person("lyx5",5));
		Iterator<Person> iterable=hashSet.iterator();
		while (iterable.hasNext()){
			Person p=iterable.next();
			System.out.println(p);
		}

		TreeSet<Person> set=new TreeSet<>();
		set.add(new Person("lyx2",2));
		set.add(new Person("lyx4",2));
		set.add(new Person("lyx4",4));
		set.add(new Person("lyx5",1));
		for (Person p:set
			 ) {
			System.out.println(p);
		}
	}
}
