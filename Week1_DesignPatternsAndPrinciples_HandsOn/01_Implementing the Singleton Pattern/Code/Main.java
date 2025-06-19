public class Main {
    public static void main(String[] args) {
        Logger l1=Logger.getInstance();
        Logger l2=Logger.getInstance();
        l1.addition(10,20);
        l2.addition(50, 30);
        System.out.println("Logger L1:");
        l1.display();
        System.out.println("Logger L2:");
        l2.display();
        if(l1==l2){
            System.out.println("Both logger instances are the same (Singleton works)");
        }
        else{
            System.out.println("Different logger instances exist (Singleton failed)");
        }
    }
}
