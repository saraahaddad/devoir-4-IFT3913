package test;

import currencyConverter.Currency;
import currencyConverter.MainWindow;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WhiteBoxCurrencyConvertTest {
    ArrayList<Currency> currencies;
    @Test
    @DisplayName("Test pour critères A et B")
    public void testAB(){
        String currency2 = "US Dollar";
        String currency1 = "Euro";
        assertEquals(1.073*100, MainWindow.convert(currency1,currency2,currencies,100.0));

        currency2 = "Lebanese Pound";
        currency1 = "Euro";
        assertEquals(0.0, MainWindow.convert(currency1,currency2,currencies,100.0));

        currency2 = "Indian Rupee";
        currency1 = "Euro";
        assertEquals(0.0, MainWindow.convert(currency1,currency2,currencies,100.0));

        currency2 = "Euro";
        currency1 = "Euro";
        assertEquals(100.0, MainWindow.convert(currency1,currency2,currencies,100.0));

        currency2 = "Euro";
        currency1 = "US Dollar";
        assertEquals(93.0, MainWindow.convert(currency1,currency2,currencies,100.0));

        currency2 = "Euro";
        currency1 = "CFA Franc";
        assertEquals(0.0, MainWindow.convert(currency1,currency2,currencies,100.0));
    }
    @Test
    @DisplayName("Tests pour critère C")
    public void testC(){
        String currency2;
        String currency1;

        // chemin 2
        currency1 = "US Dollar";
        currency2= "Euro";
        assertEquals(93.0,MainWindow.convert(currency1,currency2,currencies, 100.0));

        // chemin 3
        currency1 = "Lebanese Pound";
        currency2= "Indian Rupee";
        assertEquals(0.0,MainWindow.convert(currency1,currency2,currencies, 1000.0));

        // chemin 4
        currency1 = "Indian Rupee";
        currency2= "US Dollar";
        assertEquals(0.0,MainWindow.convert(currency1,currency2,currencies, 1200000.0));
    }

    @BeforeEach
    public void setUp(){
        currencies = Currency.init();
    }
}
