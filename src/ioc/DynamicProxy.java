package ioc;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Human{
    void eat();
}
class SuperMan implements Human{

    @Override
    public void eat() {
        System.out.println("超人喜欢吃麻辣烫！！！");
    }
}
class ProxyFactory{
    private static class MyInvocationHandler implements InvocationHandler{
        Object obj;
        public void band(Object obj){
            this.obj=obj;
        }
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Object invoke = method.invoke(obj, args);
            return invoke;
        }
    }
    public static Object getProxyInstance(Object obj){
        MyInvocationHandler handler=new MyInvocationHandler();
        handler.band(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),handler);
    }
}

public class DynamicProxy {
    public static void main(String[] args) {
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(new SuperMan());
    proxyInstance.eat();
    }
}
