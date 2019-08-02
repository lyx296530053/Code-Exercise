package cn.lyx.stack;



import java.util.Iterator;

public class ArrayStack<Item> implements MyStack<Item> {
    private Item[] a = (Item[]) new Object[1];
    private int n = 0;

    @Override
    public MyStack<Item> push(Item item) {
        check();
        a[n++] = item;
        return this;
    }

    private void check() {
        if (n >= a.length) {
            resize(2 * a.length);
        } else if (n > 0 && n <= a.length / 4) {
            resize(a.length / 2);
        }
    }

    private void resize(int i) {
        Item[] temp = (Item[]) new Object[i];
        for (int j = 0; j < n; j++) {
            temp[j]=a[j];
        }
        a = temp;
    }

    @Override
    public Item pop() throws Exception {
        if(a==null){
            throw  new Exception("stack is empty");
        }
        Item temp=a[--n];
        check();
        a[n]=null;
        return temp ;
    }

    @Override
    public boolean isEmpty() {
        return n==0;
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            @Override
            public void remove() {
            }

            private int i=n;
            @Override
            public boolean hasNext() {
                return i>0;
            }

            @Override
            public Item next() {
                return a[--i];
            }
        };
    }
}
