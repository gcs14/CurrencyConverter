package currencyConverter;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Currency conversion program
 *
 * Allows the user to select which currency they want to convert their money
 * from as well as calculates the new amount in the desire form of currency.
 *
 * @author Garrett Smith
 *
 */
public class Converter {
    // A scanner object created to accept user input from keyboard.
    static Scanner s = new Scanner(System.in);

    /**
     * Reads off the options (countries) a user choose from. Each country has an
     * assigned number the user will input when selecting their choice.
     *
     * @return A string prompting the user of their options of countries.
     */
    public static String countryOptions() {
        return "Input number from the following selection: " + "\n1 - United States " + "\t2 - European Union "
                + "\t3 - United Kingdom " + "\n4 - Switzerland" + "\t\t5 - China" + "\n> ";
    }

    /**
     * Passes an integer parameter representing a selected country from the
     * countyOptions method. Reads off a message to the user confirming using the
     * converted currency in it's respected country.
     *
     * @param x Integer representing selected country.
     * @return A string welcoming the user to the selected country
     */
    public static String oldCurrency(int x) {
        Map<Integer, String> countries = new HashMap<>();
        countries.put(1, "United States");
        countries.put(2, "European Union");
        countries.put(3, "United Kingdom");
        countries.put(4, "Switzerland");
        countries.put(5, "China");

        return "You are coming from: " + countries.get(x);
    }

    /**
     * Passes an integer parameter representing a selected country from the
     * countyOptions method. Reads off a message to the user confirming desired
     * currency of conversion.
     *
     * @param x Integer representing selected country.
     * @return A string confirming desired currency of conversion.
     */
    public static String newCurrency(int x) {
        Map<Integer, String> currencies = new HashMap<>();
        currencies.put(1, "USD");
        currencies.put(2, "EURO");
        currencies.put(3, "GBP");
        currencies.put(4, "CHF");
        currencies.put(5, "CNY");
        return "You are converting to: " + currencies.get(x);
    }

    /**
     * Returns an error message when entered integer isn't between 1 and 5.
     * Will repeat until the user inputs an integer between 1 and 5.
     * @param x The inputed number.
     * @return A valid integer.
     */
    public static int invalidEntry(int x) {
        while(x < 1 || x > 5) {
            System.out.println("\nThat is not a valid entry, try again.");
            System.out.println("What country are you coming from?\n");
            System.out.println(countryOptions());
            x = s.nextInt();
        }
        return x;
    }

    /**
     * Returns an error message when entered double isn't a positive number.
     * @param y The inputed double.
     * @return A valid amount.
     */
    public static double invalidAmount(double y) {
        while(y < 0) {
            System.out.println("\nThat is not a valid amount, try again.");
            System.out.println("How much money do you want to convert? \n> ");
            y = s.nextDouble();
        }
        return y;
    }

    public static void main(String[] args) {
        // Creates a CurrencyRates object to access information about the different
        // currencies available.
        CurrencyRates c = new CurrencyRates();
        System.out.println("What country are you coming from?\n");
        System.out.println(countryOptions());
        int oldCountry = s.nextInt();
        if (oldCountry < 1 || oldCountry > 5) {
            oldCountry = invalidEntry(oldCountry);
        }
        System.out.println("\n" + oldCurrency(oldCountry) + "\n");

        // Creates country objects to store information.
        Country usd = new Country("United States", "USD", c.countryConversionRates(oldCountry).get("United States"));
        Country euro = new Country("European Union", "EURO",
                c.countryConversionRates(oldCountry).get("European Union"));
        Country uk = new Country("United Kingdom", "GBP", c.countryConversionRates(oldCountry).get("United Kingdom"));
        Country swiss = new Country("Switzerland", "CHF", c.countryConversionRates(oldCountry).get("Switzerland"));
        Country china = new Country("China", "CNY", c.countryConversionRates(oldCountry).get("China"));

        // User input prompt asking for country of desired currency of conversion.
        System.out.println("What country's currency do you want to convert to?\n");
        System.out.println(countryOptions());
        int newCountry = s.nextInt();
        if (newCountry < 1 || newCountry > 5) {
            newCountry = invalidEntry(newCountry);
        }
        System.out.println("\n" + newCurrency(newCountry) + "\n");

        // User input prompt asking how much money the user wants to convert.
        System.out.println("How much money do you want to convert? \n> ");
        double amount = s.nextDouble();
        if (amount < 0) {
            amount = invalidAmount(amount);
        }
        
        // Logic decisions based on which currency the user wants to convert their money
        // to.
        if (newCountry == 1) {
            usd.calculate(amount);
            System.out.println(usd.toString());
        } else if (newCountry == 2) {
            euro.calculate(amount);
            System.out.println(euro.toString());
        } else if (newCountry == 3) {
            uk.calculate(amount);
            System.out.println(uk.toString());
        } else if (newCountry == 4) {
            swiss.calculate(amount);
            System.out.println(swiss.toString());
        } else if (newCountry == 5) {
            china.calculate(amount);
            System.out.println(china.toString());
        }
    }
}