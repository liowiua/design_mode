package responsibility;

class Request{ }

interface Handler{
    void setNext(Handler handler);
    void handle(Request request);
}

abstract class BaseHandler implements Handler{
    protected Handler next;

    public void setNext(Handler handler){
        this.next = handler;
    }
}

class AuthorizationHandler extends BaseHandler{

    @Override
    public void handle(Request request) {
        if(next != null){
            next.handle(request);
        }
    }
}

class AuthenticationHandler extends BaseHandler{

    @Override
    public void handle(Request request) {

        //handle something

        if(next != null){
            next.handle(request);
        }
    }
}

//class OtherHandler extends BaseHandler{
//
//    @Override
//    public void handle(Request request) {
//        if(condition is satissfied){
//
//        }else if(next != null){
//            return next.handle(request);
//        }else{
//            return false;
//        }
//    }
//}

public class Client {
}
