package DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Shop{
    void buy();
}
class Goods implements Shop{
    @Override
    public void buy() {
        System.out.println("这是哇哈哈");
    }
}
class ProxyFactory{
    public static Object getProxy(Object obj){
        MyinvocationHandler handler=new MyinvocationHandler();
        handler.band(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),handler);
    }
}
class MyinvocationHandler implements InvocationHandler{
    private Object obj;
    public void band(Object obj){
        this.obj=obj;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(obj,args);
    }
}
public class Test {
    public static void main(String[] args) {
        Shop shop = (Shop) ProxyFactory.getProxy(new Goods());
        shop.buy();
    }
}
