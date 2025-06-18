import java.util.*;
class FinancialForecasting{
    public static double futurevalue(double amount,double rate,double years){
        if(years==0){
            return amount;
        }
        return futurevalue(amount * (1 + rate), rate, years - 1);
    }
public static void main(String[] args) {
    Scanner S=new Scanner(System.in);
    System.out.println("Enter the Amount:");
    double amount=S.nextInt();
    System.out.println("Enter the rate:");
    double rate=S.nextDouble();
    System.out.println("Enter the number of years:");
    int years=S.nextInt();
    double result=futurevalue(amount,rate,years);
   System.out.printf("Future value after %d years: %.2f\n", years, result);



}
}