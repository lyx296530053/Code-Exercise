package Jieshiqi;

import java.util.StringTokenizer;

abstract class A {
    abstract boolean interpret(String s);
}

class B extends A {
    private String temp = null;

    public B(String temp) {
        this.temp = temp;
    }

    @Override
    boolean interpret(String str) {
        StringTokenizer s = new StringTokenizer(str);
        while (s.hasMoreTokens()) {
            if (s.nextToken().equals(temp)) {
                return true;
            }
        }
        return false;
    }
}
class Or extends A {
    private A a;
    private A b;

    public Or(A a, A b) {
        this.a = a;
        this.b = b;
    }

    @Override
    boolean interpret(String s) {
        return a.interpret(s) || b.interpret(s);
    }
}

class And extends A {
    private A a;
    private A b;

    public And(A a, A b) {
        this.a = a;
        this.b = b;
    }

    @Override
    boolean interpret(String s) {
        return a.interpret(s) && b.interpret(s);
    }
}

public class MyCilent {
    public static A buile() {
        B b=new B("A");
        B b1=new B("B");
        B b2=new B("C");
        B b3=new B("D");
        A a=new Or(b1,b2);
        A a1=new Or(b,a);
        return  new And(b3,a1);
    }

    public static void main(String[] args) {
    A a=buile();
    String aa="D A";
    String bb="A B ";
        System.out.println(a.interpret(aa));
        System.out.println(a.interpret(bb));
    }
}
