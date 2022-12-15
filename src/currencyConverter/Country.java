package currencyConverter;

import java.text.NumberFormat;

/**
 * Represents a country object.
 *
 * @author Garrett Smith
 *
 */
public class Country {

    private String name;
    private String code;
    private double rate;
    private double converted;

    /**
     * Creates a country with the specified name, currency code, and conversion
     * rate.
     *
     * @param n The name of the country
     * @param c The currency code of the country
     * @param r The conversion rate dictated by which country money is being
     *          converted from.
     */
    public Country(String n, String c, double r) {
        name = n;
        code = c;
        rate = r;

    }

    /**
     * Calculates the new dollar amount from one currency to another
     *
     * @param amount New amount of money in the desired currency
     * @return amount of converted money
     */
    public double calculate(double amount) {
        converted = rate * amount;
        return converted;
    }

    public String toString() {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        if (name.equalsIgnoreCase("Switzerland") || name.equalsIgnoreCase("China")) {
            return "\nConversion done! You now have " + nf.format(converted) + " in " + code + "." + "\nWelcome to "
                    + name + "!";
        } else
            return "\nConversion done! You now have " + nf.format(converted) + " in " + code + "." + "\nWelcome to the "
                    + name + "!";
    }

    /**
     * Used to get name of country
     *
     * @return name of country
     */
    public String getName() {
        return name;
    }

    /**
     * Used to input name of country
     *
     * @param name The desired name of country
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Used to get currency code of country
     *
     * @return currency code of country
     */
    public String getCode() {
        return code;
    }

    /**
     * Used to input currency code of country
     *
     * @param code The desired currency code of country
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Used to get conversion rate of country
     *
     * @return conversion rate of country
     */
    public double getRate() {
        return rate;
    }

    /**
     * Used to input conversion rate of country
     *
     * @param rate The desired conversion rate of country
     */
    public void setRate(double rate) {
        this.rate = rate;
    }
}