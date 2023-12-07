package test;

import currencyConverter.Currency;
import currencyConverter.MainWindow;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WhiteBoxCurrencyConvertTest {
    @Test
    @DisplayName("Test pour critères A et C")
    public void testAC(){
        assertEquals(135.0, Currency.convert(100.0, 1.35));
    }
}
