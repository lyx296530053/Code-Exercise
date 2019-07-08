package IteratorTest;

interface A {
    myIterator creat();
}
class Person1 implements A {
    private Integer[] arr;

    public Person1() {
        arr=new Integer[10];
        for (int i = 0; i < arr.length; i++) {
            this.arr[i] = i;
        }
    }

    @Override
    public myIterator creat() {
        return new ConcreteIterator1<Integer>(arr);
    }
}

interface myIterator<T> {
    T next();

    boolean hasNext();
}

class ConcreteIterator1<T> implements myIterator {
    private T[] arr;
    private int temp = 0;

    public ConcreteIterator1(T[] arr) {
        this.arr = arr;
    }

    @Override
    public Object next() {
        return arr[temp++];
    }

    @Override
    public boolean hasNext() {
        return temp < arr.length;
    }
}

public class MyIterator {
    public static void main(String[] args) {
        A a = new Person1();
        myIterator<Integer> creat = a.creat();
        while (creat.hasNext()) {
            System.out.println(creat.next());
        }
    }
}
