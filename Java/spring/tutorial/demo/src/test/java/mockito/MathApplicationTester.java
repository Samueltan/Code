package mockito;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTester {
    MathApplication mathApplication;
    CalculatorService calculatorService1;
    CalculatorService calculatorService2;

    @Before
    public void setUp() {
        mathApplication = new MathApplication();
        calculatorService1 = mock(CalculatorService.class);

        Calculator calculator = new Calculator();
        calculatorService2 = spy(calculator);
    }

    @Test
    public void testAddAndSubtract() {
        mathApplication.setCalculatorService(calculatorService1);
        given(calculatorService1.add(10.0, 20.0)).willReturn(30.0);
        when(calculatorService1.subtract(10.0, 20.0)).thenReturn(-10.0);

        var sum = mathApplication.add(10.0, 20.0);
        Assert.assertEquals(sum, 30.0, 0);
        var diff = mathApplication.subtract(10.0, 20.0);
        Assert.assertEquals(diff, -10.0, 0);

        InOrder inOrder = inOrder(calculatorService1);

        inOrder.verify(calculatorService1).add(10.0, 20.0);
        inOrder.verify(calculatorService1).subtract(10.0, 20.0);
    }

    @Test(expected = RuntimeException.class)
    public void testAddException() {
        mathApplication.setCalculatorService(calculatorService1);
        doThrow(new RuntimeException("Add operation not implemented")).when(calculatorService1).add(10.0, 20.0);

        var result = mathApplication.add(10.0, 20.0);
    }

    @Test
    public void testAdd() {
        mathApplication.setCalculatorService(calculatorService2);

        var sum = mathApplication.add(10.0, 20.0);
        Assert.assertEquals(sum, 30.0, 0);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testSubtract() {
        mathApplication.setCalculatorService(calculatorService2);

        var sum = mathApplication.subtract(10.0, 20.0);
    }

}
