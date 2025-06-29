import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import org.junit.Test;
public class ServiceTest {
    @Test
    public void testServiceWithMockRepository() {
        Repository mockRepository = mock(Repository.class);
        when(mockRepository.getData()).thenReturn("Mock Data");
        Service service = new Service(mockRepository);
        String result = service.processData();
        assertEquals("Processed Mock Data", result);
    }
}
