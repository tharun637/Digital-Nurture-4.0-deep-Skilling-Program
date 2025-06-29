import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.Duration;

public class PerformanceTesterTest {

    @Test
    void testPerformTaskCompletesWithin1000ms() {
        PerformanceTester tester = new PerformanceTester();
        assertTimeout(Duration.ofMillis(1000), tester::performTask);
    }

    @Test
    void testPerformTaskCompletesWithin300ms() {
        PerformanceTester tester = new PerformanceTester();
        assertTimeout(Duration.ofMillis(300), tester::performTask);
    }
}
