import org.junit.Test;
import static org.junit.Assert.*;
public class CalculatorTest {
    @Test
    public void testAdd(){
        Calculator cal=new Calculator();
        int sum=cal.add(10,20);
        assertEquals(30,sum);
    }
}
