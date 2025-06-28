public class MyService {
    ExternalApi api;
    public MyService(ExternalApi api){
        this.api=api;
    }
    public void process(){
        api.sendData("User123",42);
    }
}
