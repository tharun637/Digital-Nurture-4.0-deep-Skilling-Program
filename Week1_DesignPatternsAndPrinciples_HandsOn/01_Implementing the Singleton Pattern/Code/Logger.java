public class Logger{
    private static Logger instance;
    private Logger(){

    }
    private int a;
    private int b;
    public static Logger getInstance(){
        if(instance==null){
            instance=new Logger();
        }
        return instance;
    }
    public void addition(int x,int y){
        this.a=x;
        this.b=y;
    }
    public void display(){
        System.out.println("First Value:"+a);
        System.out.println("Second Value:"+b);
        System.out.println("Addition of two values:"+(a+b));
        System.out.println();
    }
}
