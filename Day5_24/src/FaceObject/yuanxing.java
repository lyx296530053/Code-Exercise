package FaceObject;

abstract class A {
    abstract A a();
}

class B extends A {
    String a;

    public B(String a) {
        this.a = a;
    }

    @Override
    A a() {
        return new B(a);
    }

    @Override
    public String toString() {
        return a;
    }
}

public class yuanxing {
    public static void main(String[] args) {
        A a = new B("aaa");
        A a1 = a.a();
        System.out.println(a1.a());
    }
}
