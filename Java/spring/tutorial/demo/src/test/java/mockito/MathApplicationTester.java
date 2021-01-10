package mockito;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTester {
    @InjectMocks
    MathApplication mathApplication = new MathApplication();

    @Mock
    CalculatorService calculatorService;

    @Test
    public void testAdd() {
        when(calculatorService.add(10.0, 20.0)).thenReturn(30.0);

        var result = mathApplication.add(10.0, 20.0);
        Assert.assertEquals(result, 30.0, 0);

        verify(calculatorService).add(10.0, 20.0);
    }

    @Test(expected = RuntimeException.class)
    public void testAddException() {
        doThrow(new RuntimeException("Add operation not implemented")).when(calculatorService).add(10.0, 20.0);

        var result = mathApplication.add(10.0, 20.0);
        Assert.assertEquals(result, 30.0, 0);

        verify(calculatorService).add(10.0, 20.0);
    }
}
