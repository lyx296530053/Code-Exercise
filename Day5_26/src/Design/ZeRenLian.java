package Design;

abstract class Handler {
    protected Handler request;

    public Handler(Handler request) {
        this.request = request;
    }

    abstract void handlerRequest(Request request);
}

class A extends Handler {

    public A(Handler request) {
        super(request);
    }

    @Override
    void handlerRequest(Request request) {
        if (request.name == "lyx") {
            System.out.println("A");
            return;
        }
        if (this.request != null) {
            this.request.handlerRequest(request);
        }
    }
}

class B extends Handler {

    public B(Handler request) {
        super(request);
    }

    @Override
    void handlerRequest(Request request) {
        if (request.name == "abc") {
            System.out.println("B");
            return;
        }
        if (this.request != null) {
            this.request.handlerRequest(request);
        }
    }
}

class Request {
    String name;

    public Request(String name) {
        this.name = name;
    }
}

public class ZeRenLian {
    public static void main(String[] args) {
        Handler handler = new A(null);
        Handler handler1 = new B(handler);
        handler1.handlerRequest(new Request("lyx"));
    }
}
