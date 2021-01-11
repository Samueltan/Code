package mockito;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MathApplicationTester {
    MathApplication mathApplication;
    CalculatorService calculatorService1;
    CalculatorService calculatorService2;

    @BeforeEach
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
        Assertions.assertEquals(sum, 30.0);
        var diff = mathApplication.subtract(10.0, 20.0);
        Assertions.assertEquals(diff, -10.0);

        InOrder inOrder = inOrder(calculatorService1);

        inOrder.verify(calculatorService1).add(10.0, 20.0);
        inOrder.verify(calculatorService1).subtract(10.0, 20.0);
    }

    @Test
    public void testAddException() {
        mathApplication.setCalculatorService(calculatorService1);
        doThrow(new RuntimeException("Add operation not implemented")).when(calculatorService1).add(10.0, 20.0);

        assertThrows(
            RuntimeException.class,
            () -> mathApplication.add(10.0, 20.0)
        );
    }

    @Test
    public void testAdd() {
        mathApplication.setCalculatorService(calculatorService2);

        var sum = mathApplication.add(10.0, 20.0);
        Assertions.assertEquals(sum, 30.0, 0);
    }

    @Test
    public void testSubtract() {
        mathApplication.setCalculatorService(calculatorService2);

        assertThrows(
            UnsupportedOperationException.class,
            () -> mathApplication.subtract(10.0, 20.0)
        );
    }

}
