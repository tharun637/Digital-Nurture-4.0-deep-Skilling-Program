public class NotificationService {
    private final Notifier notifier;

    public NotificationService(Notifier notifier) {
        this.notifier = notifier;
    }

    public void alert(String message) {
        notifier.sendNotification(message);
    }
}

