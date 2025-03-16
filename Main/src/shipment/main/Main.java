package shipment.main;

import shipment.api.TaxesCalculator;

import java.util.Iterator;
import java.util.ServiceLoader;

public class Main {
    public static void main(String[] args) {

        Iterator<TaxesCalculator> services = ServiceLoader.load(TaxesCalculator.class).iterator();

        while(services.hasNext()) {
            System.out.println(services.next().getClass());
        }
    }
}