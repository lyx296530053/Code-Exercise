package cn.lyx.StaticTest;

//懒汉单例
class A {
    private static A a;

    private A() {
    }

    public static A getA() {
        if (a == null) {
            a = new A();
        }
        return a;
    }
}

//恶汉单例
class B {
    private static final B b = new B();

    private B() {
    }

    public static B getB() {
        return b;
    }
}
//双重锁校验
class C {
    private volatile static C c;

    private C() {
    }

    public static C getC() {
        if (c == null) {
            synchronized (C.class) {
                if (c == null) {
                    c = new C();
                }
            }
        }
        return c;
    }
}
//静态内部类
class D{
    private D(){}
    private static class getD{
        private static final D d=new D();
    }
    public static D getD(){
        return getD.d;
    }
}
//枚举方式
enum E{
    e;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
public class SingleExample {
    public static void main(String[] args) {
        E single=E.e;
       single.setName("aaa");
        System.out.println(single.getName());
        E a = E.e;
        System.out.println(a.getName());
        E b = E.e;
        System.out.println(b.getName());
    }
}
