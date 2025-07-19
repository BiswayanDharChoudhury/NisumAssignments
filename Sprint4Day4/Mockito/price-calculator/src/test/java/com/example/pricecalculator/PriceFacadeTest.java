package com.example.pricecalculator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

@RunWith(org.mockito.junit.MockitoJUnitRunner.class)
public class PriceFacadeTest {

    private PriceCalculator realCalculator;
    @Spy
    private PriceFacade priceFacade;

    @Before
    public void setup() {
        realCalculator = spy(new PriceCalculator());
        priceFacade = spy(new PriceFacade(realCalculator));
    }

    @Test
    public void testGetPrice_returnsDefaultOnArithmeticException() throws Exception {
        PriceCalculator localCalculator = spy(new PriceCalculator());
        PriceFacade localFacade = spy(new PriceFacade(localCalculator));

        // Stub the private method 'calculateTax' to throw ArithmeticException
        // Use doThrow on the public method for legacy class; private methods can't be stubbed directly, so simulate indirectly
        doThrow(new ArithmeticException()).when(localCalculator).getPriceWithTax(anyDouble());

        double result = localFacade.getPrice(100.0);

        assertEquals(-1.0, result, 0.0001);
    }

    @Test
    public void testGetPrice_afterResetSpy_invokesRealMethod() {
        PriceCalculator localCalculator = spy(new PriceCalculator());
        PriceFacade localFacade = spy(new PriceFacade(localCalculator));

        doThrow(new ArithmeticException()).when(localCalculator).getPriceWithTax(anyDouble());

        double result1 = localFacade.getPrice(200.0);
        assertEquals(-1.0, result1, 0.0001);

        reset(localCalculator);

        double result2 = localFacade.getPrice(200.0);
        double expected = 200.0 + 200.0 * 0.18;
        assertEquals(expected, result2, 0.0001);
    }
}
