package FaceObject;

class Person {
    Integer[] arr;

    public Person() {
        arr = new Integer[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = i;
        }
    }


    public MyIterator iterator() {
        return new ConcreatIterator<Integer>(arr);
    }
}

interface MyIterator<T> {

    boolean hasNext();

    Object next();
}

class ConcreatIterator<T> implements MyIterator {
    private T[] arr;
    private int size;

    public ConcreatIterator(T[] arr) {
        this.arr = arr;
    }

    @Override
    public boolean hasNext() {
        return size<arr.length;
    }

    @Override
    public Object next() {
       return arr[size++];
    }
}

public class Iterator {
    public static void main(String[] args) {
Person p=new Person();
        MyIterator iterator = p.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
