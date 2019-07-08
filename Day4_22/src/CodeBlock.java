class Person{
    public Person() {
        System.out.println("普通类构造方法");
    }

    {
        System.out.println("普通类中代码块");
    }
    static {
        System.out.println("普通类中静态快");
    }
}
public class CodeBlock extends Person {
    public CodeBlock() {
        System.out.println("主类构造方法");
    }

    {
        System.out.println("主类中代码块");
    }
    static {
        System.out.println("主类中静态快");
    }
    public static void main(String[] args) {
        System.out.println("---start---");
        new CodeBlock();
        new CodeBlock();
        System.out.println("---end---");
    }
}
