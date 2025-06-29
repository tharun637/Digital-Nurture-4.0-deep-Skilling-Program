import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExceptionThrowerTest {
    @Test
    void testExceptionIsThrown() {
        ExceptionThrower thrower = new ExceptionThrower();

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            thrower.throwException(true);
        });
        assertEquals("Invalid argument provided!", exception.getMessage());
    }
    @Test
    void testNoExceptionIsThrown() {
        ExceptionThrower thrower = new ExceptionThrower();
        assertDoesNotThrow(() -> thrower.throwException(false));
    }
}
