import org.junit.Test;
import org.mockito.InOrder;

import static org.mockito.Mockito.*;

public class WorkflowTest {

    @Test
    public void testMethodCallOrder() {

        Service mockService = mock(Service.class);
        Workflow wf = new Workflow(mockService);
        wf.execute();
        InOrder inOrder = inOrder(mockService);
        inOrder.verify(mockService).start();
        inOrder.verify(mockService).process();
        inOrder.verify(mockService).end();
    }
}
