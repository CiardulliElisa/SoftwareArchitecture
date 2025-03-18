package shipment.italy;

import shipment.api.Shipment;
import shipment.api.TaxesCalculator;

public class ItalyTaxes implements TaxesCalculator {
    public double calculateTax(Shipment s) {
        return 0;
    }

    public String getCountry() {
        return "";
    }
}
