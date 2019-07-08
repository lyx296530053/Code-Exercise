abstract class Handler{
    protected Handler handler;
    public Handler(Handler handler) {
        this.handler = handler;
    }
    protected abstract void handleRequest(Request request);
}
 class Implements extends Handler{
    public Implements(Handler handler){
        super(handler);
    }
    @Override
    protected void handleRequest(Request request) {
        if(request.requestType==RequestType.TYPE1){
            System.out.println(request.getName()+"a");
            return;
        }
        if(handler!=null){
         handler.handleRequest(request);
        }
    }
}
class Implements1 extends Handler{
    public Implements1(Handler handler){
        super(handler);
    }
    @Override
    protected void handleRequest(Request request) {
        if(request.requestType==RequestType.TYPE2){
            System.out.println(request.getName()+"b");
            return;
        }
        if(handler!=null){
            handler.handleRequest(request);
        }
    }
}
class Request{
    public RequestType requestType;
    public String name;

    public Request(RequestType requestType, String name) {
        this.requestType = requestType;
        this.name = name;
    }

    public RequestType getRequestType() {
        return requestType;
    }

    public String getName() {
        return name;
    }
}
enum RequestType{
    TYPE1,TYPE2
}
public class ZeRenLian {
    public static void main(String[] args) {
        Handler handler=new Implements(null);
        Handler handler1=new Implements1(handler);
        Request request=new Request(RequestType.TYPE1,"lyx");
        handler1.handleRequest(request);
        Request request1=new Request(RequestType.TYPE2,"wsc");
        handler1.handleRequest(request1);
    }
}
