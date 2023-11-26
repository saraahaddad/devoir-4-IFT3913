package test;

import currencyConverter.Currency;
import currencyConverter.MainWindow;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainWindowConvertTest {

    ArrayList<Currency> currencies;

    @Test
    @DisplayName("Test for 500 000")
    public void testT1(){
        assertEquals(465000.0,
                MainWindow.convert("US Dollar", "Euro", currencies, 500000.0));
    }

    @Test
    @DisplayName("Test for -500 000")
    public void testT2(){

    }

    @Test
    @DisplayName("Test for 1 500 000")
    public void testT3(){

    }

    @Test
    @DisplayName("Test for 0 and 1 000 000")
    public void testT4(){
        assertEquals(0, MainWindow.convert(
                "Chinese Yuan Renminbi", "Japanese Yen", currencies, 0.0));

        assertEquals(19410000, MainWindow.convert(
                "Chinese Yuan Renminbi", "Japanese Yen", currencies, 1000000.0));
    }

    @Test
    @DisplayName("Test for -1")
    public void testT5(){

    }

    @Test
    @DisplayName("Test for 1 000 001")
    public void testT6(){

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
