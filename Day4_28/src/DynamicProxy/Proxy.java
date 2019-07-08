package DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

interface Ihuman{
    void show();
    String eat(String str);
}
class SuperMan implements Ihuman{

    @Override
    public void show() {
        System.out.println("超人不会飞!!!");
    }

    @Override
    public String eat(String str) {
        return str;
    }
}
class ProxyFactory{

    public static Object getProxyObject(Object obj){
        MyInvocationHandler handler=new MyInvocationHandler();
        handler.getHandler(obj);
        return java.lang.reflect.Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),handler);
    }
}
 class MyInvocationHandler implements InvocationHandler {
    private Object obj;

    public void getHandler(Object obj){
        this.obj=obj;
    }

     @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object value=method.invoke(obj,args);
        return value;
    }
}
public class Proxy {
    public static void main(String[] args) {
        Ihuman proxyObject = (Ihuman) ProxyFactory.getProxyObject(new SuperMan());
        System.out.println(proxyObject.eat("四川麻辣烫"));
        proxyObject.show();
    }
}
