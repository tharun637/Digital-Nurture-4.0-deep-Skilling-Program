public class MyService {
    Logger logger;
    public MyService(Logger logger){
        this.logger=logger;
    }
    public void Work(){
        logger.log("Hi You are Login....");
    }
}
