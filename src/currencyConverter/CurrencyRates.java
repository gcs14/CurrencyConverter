package currencyConverter;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Represents the conversion rates from perspective of the currency being
 * converted
 *
 * @author Garrett Smith
 *
 */
public class CurrencyRates {

    public Map<String, Double> countryConversionRates(int n) {
        Map<String, Double> usd = Stream.of(new AbstractMap.SimpleEntry<>("United States", 1.00),
                        new AbstractMap.SimpleEntry<>("European Union", 0.95026),
                        new AbstractMap.SimpleEntry<>("United Kingdom", 0.79897),
                        new AbstractMap.SimpleEntry<>("Switzerland", 0.97757), new AbstractMap.SimpleEntry<>("China", 6.60631))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        Map<String, Double> euro = Stream.of(new AbstractMap.SimpleEntry<>("United States", 1.05217),
                        new AbstractMap.SimpleEntry<>("European Union", 1.00),
                        new AbstractMap.SimpleEntry<>("United Kingdom", 0.8407),
                        new AbstractMap.SimpleEntry<>("Switzerland", 1.02865), new AbstractMap.SimpleEntry<>("China", 6.95095))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        Map<String, Double> uk = Stream.of(new AbstractMap.SimpleEntry<>("United States", 1.25138),
                        new AbstractMap.SimpleEntry<>("European Union", 1.1892),
                        new AbstractMap.SimpleEntry<>("United Kingdom", 1.00),
                        new AbstractMap.SimpleEntry<>("Switzerland", 1.22342), new AbstractMap.SimpleEntry<>("China", 8.267))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        Map<String, Double> swiss = Stream.of(new AbstractMap.SimpleEntry<>("United States", 1.02271),
                        new AbstractMap.SimpleEntry<>("European Union", 0.97193),
                        new AbstractMap.SimpleEntry<>("United Kingdom", 0.81717),
                        new AbstractMap.SimpleEntry<>("Switzerland", 1.00), new AbstractMap.SimpleEntry<>("China", 6.75637))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        Map<String, Double> china = Stream.of(new AbstractMap.SimpleEntry<>("United States", 0.15128),
                        new AbstractMap.SimpleEntry<>("European Union", 0.14375),
                        new AbstractMap.SimpleEntry<>("United Kingdom", 0.12087),
                        new AbstractMap.SimpleEntry<>("Switzerland", 0.14789), new AbstractMap.SimpleEntry<>("China", 1.00))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        Map<Integer, Map<String, Double>> chosen = Stream
                .of(new AbstractMap.SimpleEntry<>(1, usd), new AbstractMap.SimpleEntry<>(2, euro),
                        new AbstractMap.SimpleEntry<>(3, uk), new AbstractMap.SimpleEntry<>(4, swiss),
                        new AbstractMap.SimpleEntry<>(5, china))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        return chosen.get(n);
    }
}