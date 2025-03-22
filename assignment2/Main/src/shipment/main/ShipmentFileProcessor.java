package shipment.main;

import shipment.api.Shipment;
import shipment.api.ShipmentReader;
import shipment.api.TaxesCalculator;

import java.util.*;

public class ShipmentFileProcessor {

    private static Map<String, TaxesCalculator> taxesCalculatorMap = new HashMap<>();
    private static Map<String, ShipmentReader> shipmentReaderMap = new HashMap<>();

    public static void main(String[] args) {

        Iterator<TaxesCalculator> services = ServiceLoader.load(TaxesCalculator.class).iterator();

        while(services.hasNext()) {
            TaxesCalculator calculator = services.next();
            taxesCalculatorMap.put(calculator.getCountry(), calculator);
        }

        Iterator<ShipmentReader> services2 = ServiceLoader.load(ShipmentReader.class).iterator();

        while(services2.hasNext()) {
            ShipmentReader reader = services2.next();
            shipmentReaderMap.put(reader.getFileType(), reader);
        }

        double csv_total = totalTaxes("shipments.csv");
        double xml_total = totalTaxes("shipments.xml");

        System.out.println(csv_total);
        System.out.println(xml_total);
    }

    public static double totalTaxes(String fileName) {
        double totalTaxes = 0.0;
        String extension = fileName.substring(fileName.indexOf(".") + 1);
        ShipmentReader reader = shipmentReaderMap.get(extension);
        System.out.println(shipmentReaderMap.get(extension));
        List<Shipment> shipments = reader.readFile(fileName);
        for(Shipment s : shipments) {
            TaxesCalculator calculator = taxesCalculatorMap.get(s.getCountry());
            if(calculator == null) {
                System.out.println("No tax calculator for " + s.getCountry());
            } else {
                totalTaxes += calculator.calculateTax(s);
            }
        }
        return totalTaxes;
    }
}