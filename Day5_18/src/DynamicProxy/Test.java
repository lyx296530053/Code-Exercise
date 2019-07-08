package DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Apple{
    void show();
    void money();
}

class Orchard implements Apple{

    @Override
    public void show() {
        System.out.println("这是红富士");
    }

    @Override
    public void money() {
        System.out.println("800bokuai");
    }
}

class ProxyFactory{
    public static Object getProxy(Object o){
         return Proxy.newProxyInstance(o.getClass().getClassLoader(), o.getClass().getInterfaces(), new InvocationHandler() {
             @Override
             public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                 return method.invoke(o,args);
             }
         });
    }
}



public class Test {
    public static void main(String[] args) {
        Apple apple=(Apple) ProxyFactory.getProxy(new Orchard());
        apple.show();
        apple.money();
    }
}
