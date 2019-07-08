package Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Human{
    void show();
    int age();
}
class SuperMan implements Human{

    @Override
    public void show() {
        System.out.println("超人喜欢吃四川麻辣烫");
    }

    @Override
    public int age() {
        return 123;
    }
}
class ProxyFactory{
    public static Object factory(Object obj){
        Myhandler myhandler=new Myhandler();
        myhandler.band(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),myhandler);
    }
}
class Myhandler implements InvocationHandler{
    private Object obj;

    public void band(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(obj,args);
    }
}
public class DynamicProxy {
    public static void main(String[] args) {
        Human factory = (Human) ProxyFactory.factory(new SuperMan());
        factory.show();
        System.out.println(factory.age());
    }
}
