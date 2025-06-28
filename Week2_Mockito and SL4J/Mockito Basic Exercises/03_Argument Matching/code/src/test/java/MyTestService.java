import org.junit.Test;

import static org.mockito.AdditionalMatchers.gt;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

public class MyTestService {
    @Test
    public void testargumentmatching(){
        ExternalApi mockApi=mock(ExternalApi.class);
        MyService service=new MyService(mockApi);
        service.process();
        verify(mockApi).sendData(eq("User123"), eq(42));
        verify(mockApi).sendData(anyString(), anyInt());
        verify(mockApi).sendData(startsWith("User"), gt(40));
    }
}
