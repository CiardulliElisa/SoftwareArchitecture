package shipment.brazil;

import shipment.api.Shipment;
import shipment.api.TaxesCalculator;

public class BrazilTaxes implements TaxesCalculator {
    public double calculateTax(Shipment s) {
        return 0;
    }

    public String getCountry() {
        return "";
    }
}
