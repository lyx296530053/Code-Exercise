package cn.lyx.StaticTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface  A3{
    void show();
}
class B3 implements A3{
    @Override
    public void show(){
        System.out.println("科大欢迎你");
    }
}
class ProxyFactory {
    public static Object getProxy(Object o){
       return Proxy.newProxyInstance(o.getClass().getClassLoader(), o.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
               return method.invoke(o,args);
            }
        });
    }
}
public class DynamicProxy {
    public static void main(String[] args) {
        A3 proxy = (A3) ProxyFactory.getProxy(new B3());
        proxy.show();
    }
}
