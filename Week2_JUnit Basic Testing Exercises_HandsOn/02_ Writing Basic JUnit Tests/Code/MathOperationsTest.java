import org.junit.Test;

import static org.junit.Assert.*;

public class MathOperationsTest {
    MathOperations math=new MathOperations();
    @Test
    public void add(){
        int sum=math.add(5,5);
        assertEquals(10,sum);
    }
    @Test
    public void sub(){
        int sub= math.subtract(10,5);
        assertEquals(5,sub);
    }
    @Test
    public void mul(){
        int mul=math.Multiply(3,4);
        assertEquals(12,mul);
    }
}
