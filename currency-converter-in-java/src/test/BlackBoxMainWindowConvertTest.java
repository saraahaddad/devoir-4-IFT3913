package test;

import currencyConverter.Currency;
import currencyConverter.MainWindow;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BlackBoxMainWindowConvertTest {

    ArrayList<Currency> currencies;

    @Test
    @DisplayName("Test for 500 000")
    public void testT1(){
        assertEquals(465000.0,
                // currencies are defined in specification -> test should pass
                MainWindow.convert("US Dollar", "Euro", currencies, 500000.0));

        assertEquals(500000.0,
                // currency is defined in specification -> test should pass
                MainWindow.convert("US Dollar", "US Dollar", currencies, 500000.0));
    }

    @Test
    @DisplayName("Test for CAD and CNY currencies")
    public void testCurrencies(){
        assertEquals(-1.0,
                // CNY not defined in specification -> test should fail
                MainWindow.convert("US Dollar", "Chinese Yuan Renminbi", currencies, 10.0));

        assertEquals(13.50,
                // currencies are defined in specification -> test should pass
                MainWindow.convert("US Dollar", "Canadian Dollar", currencies, 10.0));
    }

    @Test
    @DisplayName("Test for -500 000")
    public void testT2(){
        // negative value should not be converted
        assertEquals(-1.0,
                MainWindow.convert("US Dollar", "Euro", currencies, -500000.0));

        assertEquals(-1.0,
                MainWindow.convert("Euro", "Euro", currencies, -500000.0));
    }

    @Test
    @DisplayName("Test for 1 500 000")
    public void testT3(){
        // value is not in the interval of acceptable amounts
        assertEquals(-1.0,
                // arbitrary currencies
                MainWindow.convert("British Pound", "Swiss Franc", currencies, 1500000.0));
    }

    @Test
    @DisplayName("Test for 0 and 1 000 000")
    public void testT4(){
        // should be converted as expected
        assertEquals(0, MainWindow.convert(
                "Chinese Yuan Renminbi", "Japanese Yen", currencies, 0.0));

        assertEquals(1520000, MainWindow.convert(
                "British Pound", "Swiss Franc", currencies, 1000000.0));
    }

    @Test
    @DisplayName("Test for -1")
    public void testT5(){
        // negative value should not be converted
        assertEquals(-1.0,
                MainWindow.convert("Japanese Yen", "US Dollar", currencies, -1.0));
    }

    @Test
    @DisplayName("Test for 1 000 001")
    public void testT6(){
        // value is not in the interval of acceptable amounts
        assertEquals(-1.0,
                MainWindow.convert("Japanese Yen", "US Dollar", currencies, 1000001.0));

        assertEquals(-1.0,
                MainWindow.convert("Japanese Yen", "Japanese Yen", currencies, 1000001.0));
    }

    @BeforeEach
    public void setUp(){
        currencies = Currency.init();
    }

    /*
     T1 = {500 000}
     T2 = {-500 000}
     T3 = {1 500 000}
     T4 = {0, 1 000 000}
     T5 = {-1}
     T6 = {1 000 001}
     */

}