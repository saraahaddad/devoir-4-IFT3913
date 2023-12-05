package test;

import currencyConverter.Currency;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BlackBoxCurrencyConvertTest {
    ArrayList<Currency> currencies;

    @Test
    @DisplayName("Test for 500 000")
    public void testT1(){
        assertEquals(465000.0,
                // currencies and value are defined in specification -> test should pass
                Currency.convert(500000.0, 0.93));

        assertEquals(500000.0,
                // currency and value are defined in specification -> test should pass
                Currency.convert(500000.0, 1.0));
    }

    @Test
    @DisplayName("Test for CAD and CNY currencies")
    public void testCurrencies(){
        assertEquals(-1.0,
                // CNY not defined in specification -> test should fail
                Currency.convert(10.0, 6.36));

        assertEquals(13.50,
                // CAD defined in specification -> test should pass
                Currency.convert(10.0, 1.35));
    }

    @Test
    @DisplayName("Test for -500 000")
    public void testT2(){
        // negative value should not be converted
        assertEquals(-1.0,
                Currency.convert( -500000.0, 0.71));

        assertEquals(-1.0,
                Currency.convert( -500000.0, 1.41));
    }

    @Test
    @DisplayName("Test for 1 500 000")
    public void testT3(){
        // value is not in the interval of acceptable amounts
        assertEquals(-1.0,
                // arbitrary currencies
                Currency.convert( 1500000.0, 0.16));
    }

    @Test
    @DisplayName("Test for 0 and 1 000 000")
    public void testT4(){
        // should be converted as expected
        assertEquals(0, Currency.convert(0.0, 1.073));
        assertEquals(1520000, Currency.convert(1000000.0, 1.52));
    }

    @Test
    @DisplayName("Test for -1")
    public void testT5(){
        // negative value should not be converted
        assertEquals(-1.0, Currency.convert(-1.0, 1.52));
    }

    @Test
    @DisplayName("Test for 1 000 001")
    public void testT6(){
        // value is not in the interval of acceptable amounts
        assertEquals(-1.0, Currency.convert(1000001.0, 0.66));
        assertEquals(-1.0, Currency.convert(1000001.0, 19.41));
    }

    @BeforeEach
    public void setUp(){
        currencies = Currency.init();
    }
}
