package notifier;

public class Main {
    public static void main(String[] args) {
        Notifier emailNotifier = new EmailNotifier();
        Notifier smsNotifier = new SMSNotifierDecorator(emailNotifier);
        Notifier fullNotifier = new SlackNotifierDecorator(smsNotifier);

        System.out.println("---- Sending Notification via Email, SMS, and Slack ----");
        fullNotifier.send("System maintenance at 2 AM.");
    }
}
