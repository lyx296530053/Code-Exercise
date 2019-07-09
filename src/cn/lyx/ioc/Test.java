package ioc;

/**
 * ioc 对象控制权反转
 * DI 依赖注入
 * AOP 面向切面
 * Created by lyx on 2019/4/9.
 */
public class Test {
    public  static  void main(String[] args){
        MySpring4_16 mp=new MySpring4_16();
        Person person=(Person) mp.getBean("ioc.Person");
        System.out.println(person);
    }
}
