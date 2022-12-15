package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;
import currencyConverter.Converter;

public class CurrencyConverterTest {

    @SuppressWarnings("unused")
    private Converter converter;

    @Test
    public void testCountryOptions() {
        assertNotEquals(null, Converter.countryOptions());
    }

    @Test
    public void testOldCountry() {
        assertEquals("You are coming from: United States", Converter.oldCurrency(1));
        assertEquals("You are coming from: European Union", Converter.oldCurrency(2));
        assertEquals("You are coming from: United Kingdom", Converter.oldCurrency(3));
        assertEquals("You are coming from: Switzerland", Converter.oldCurrency(4));
        assertEquals("You are coming from: China", Converter.oldCurrency(5));
    }

    @Test
    public void testNewCountry() {
        assertEquals("You are converting to: USD", Converter.newCurrency(1));
        assertEquals("You are converting to: EURO", Converter.newCurrency(2));
        assertEquals("You are converting to: GBP", Converter.newCurrency(3));
        assertEquals("You are converting to: CHF", Converter.newCurrency(4));
        assertEquals("You are converting to: CNY", Converter.newCurrency(5));
    }

    @Test
    public void testInvalidEntry() {
        assertEquals(5, Converter.invalidEntry(5));
        assertEquals(3, Converter.invalidEntry(3));
        assertNotEquals(0, Converter.invalidEntry(1));
        assertNotEquals(6, Converter.invalidEntry(1));
    }

    @Test
    public void testInvalidAmount() {
        assertEquals(400, Converter.invalidAmount(400), 0);
        assertNotEquals(0, Converter.invalidAmount(0.1), 0);
    }
}
