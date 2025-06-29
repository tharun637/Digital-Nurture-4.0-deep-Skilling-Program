import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class NotificationServiceTest {

    @Test
    public void testSendNotification_throwsException() {
        Notifier mockNotifier = mock(Notifier.class);
        doThrow(new RuntimeException("Notification failed"))
                .when(mockNotifier).sendNotification("Urgent!");
        NotificationService service = new NotificationService(mockNotifier);
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            service.alert("Urgent!");
        });
        assertEquals("Notification failed", exception.getMessage());
        verify(mockNotifier).sendNotification("Urgent!");
    }
}
