package Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Human{
    void eat(String str);
}
class SuperMan implements Human{

    @Override
    public void eat(String str) {
        System.out.println("超人喜欢吃"+str);
    }
}
class HumanUtil{
    public void method1(){
        System.out.println("====================通用方法一====================");

    }
    public void method2(){
        System.out.println("====================通用方法二====================");
    }
}
class ProxyFactory{

    public static Object getProxyInstance(Object obj){
        MyInvocationHandler handler=new MyInvocationHandler();
        handler.band(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),handler);
    }
}
class MyInvocationHandler implements InvocationHandler{
    private Object obj;
    public void band(Object obj){
    this.obj=obj;
}
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        HumanUtil util=new HumanUtil();
        util.method1();
        Object returnValue = method.invoke(obj, args);
        util.method2();
        return  returnValue;
    }
}
public class DynamicProxy {
    public static void main(String[] args) {
        Human proxyInstance =(Human) ProxyFactory.getProxyInstance(new SuperMan());
        proxyInstance.eat("四川麻辣烫");
        Icloth proxyInstance1 =(Icloth) ProxyFactory.getProxyInstance(new RealProduct());
        proxyInstance1.productClose();
    }
}
