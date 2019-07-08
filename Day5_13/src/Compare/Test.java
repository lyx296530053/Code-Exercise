package Compare;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

class Computer implements Comparable {
    private String name;
    private double price;

    public Computer(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Computer) {
            Computer computer = (Computer) o;
            if (this.price > computer.price) {
                return 1;
            } else if (this.price < computer.price) {
                return -1;
            } else {
                return this.name.compareTo(computer.name);
            }
        }
        throw new RuntimeException("传入数据类型不一致");
    }

    @Override
    public String toString() {
        return "Computer{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

class Computer01 {
    private String name;
    private double price;

    public Computer01(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Computer01{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

public class Test {
    public static void main(String[] args) {
        TreeSet treeSet = new TreeSet();
        treeSet.add(new Computer("b", 15));
        treeSet.add(new Computer("c", 13));
        treeSet.add(new Computer("a", 12));
        treeSet.add(new Computer("d", 11));
        Iterator iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Computer01 && o2 instanceof Computer01) {
                    Computer01 computer01 = (Computer01) o1;
                    Computer01 computer02 = (Computer01) o2;
                    return Double.compare(computer01.getPrice(), computer02.getPrice());
                } else {
                    throw new RuntimeException("传入数据类型不一致");
                }
            }
        };
        TreeSet treeSet1 = new TreeSet(comparator);
        treeSet1.add(new Computer01("b", 15));
        treeSet1.add(new Computer01("c", 13));
        treeSet1.add(new Computer01("a", 12));
        treeSet1.add(new Computer01("d", 11));
        Iterator iterator1 = treeSet1.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }
    }
}
