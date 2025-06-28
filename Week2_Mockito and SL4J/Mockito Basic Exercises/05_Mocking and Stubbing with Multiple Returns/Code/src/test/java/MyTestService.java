import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MyTestService {
    @Test
    public void TestMethod(){
        ExternalApi mockobj=mock(ExternalApi.class);
        when(mockobj.getStatus())
                .thenReturn("Loading")
                .thenReturn("In Progress")
                .thenReturn("Complete");
        TestService service = new TestService(mockobj);
        assertEquals("Loading", service.checkProgress());
        assertEquals("In Progress", service.checkProgress());
        assertEquals("Complete", service.checkProgress());
    }
}
