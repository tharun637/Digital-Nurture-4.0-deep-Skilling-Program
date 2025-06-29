import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderedTests {

    @Test
    @Order(3)
    void testC() {
        System.out.println("Test Method 1...");
    }

    @Test
    @Order(1)
    void testA() {
        System.out.println("Test Method 2....");
    }

    @Test
    @Order(2)
    void testB() {
        System.out.println("Test Method 3...");
    }
}
