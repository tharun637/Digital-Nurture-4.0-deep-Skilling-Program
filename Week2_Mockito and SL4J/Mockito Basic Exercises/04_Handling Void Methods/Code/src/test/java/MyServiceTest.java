import org.junit.Test;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;


public class MyServiceTest {
    @Test
    public void TestMethod(){
        Logger mockobj=mock(Logger.class);
        doNothing().when(mockobj).log(anyString());
        MyService service=new MyService(mockobj);
        service.Work();
        verify(mockobj).log(eq("Hi You are Login...."));
    }
}
