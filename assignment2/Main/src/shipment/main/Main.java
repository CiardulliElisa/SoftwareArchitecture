package shipment.main;

import shipment.api.TaxesCalculator;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;

public class Main {

    private static Map<String, TaxesCalculator> taxesCalculatorMap = new HashMap<>();

    public static void main(String[] args) {

        Iterator<TaxesCalculator> services = ServiceLoader.load(TaxesCalculator.class).iterator();

        while(services.hasNext()) {
            TaxesCalculator calculator = services.next();
            taxesCalculatorMap.put(calculator.getCountry(), calculator);
        }
    }
}