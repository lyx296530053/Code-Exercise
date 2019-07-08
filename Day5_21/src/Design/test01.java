package Design;

abstract class Handler{
    protected Handler h;

    public Handler(Handler h) {
        this.h = h;
    }
    protected abstract void handleRequest(Request request);
}
class A extends Handler{
    public A(Handler h) {
        super(h);
    }

    @Override
    protected void handleRequest(Request request) {
        if(request.a==1){
            System.out.println("1chuli");
            return;
        }
        if(h!=null){
            h.handleRequest(request);
        }
    }
}
class B extends Handler{
    public B(Handler h) {
        super(h);
    }

    @Override
    protected void handleRequest(Request request) {
        if(request.a==2){
            System.out.println("2chuli");
            return;
        }
        if(h!=null){
            h.handleRequest(request);
        }
    }
}
class Request{
    int a;

    public Request(int a) {
        this.a = a;
    }
}
public class test01 {
    public static void main(String[] args) {
        Handler handler=new A(null);
        Handler handler1=new B(handler);
        handler1.handleRequest(new Request(1));
    }
}
