public class Main {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();
        System.out.println();
        context.setPaymentStrategy(new CreditCardPayment("1234-5678-9012-3456", "Tharun"));
        context.processPayment(1500.00);

        context.setPaymentStrategy(new PayPalPayment("tharun@gmail.com"));
        context.processPayment(2500.00);
    }
}