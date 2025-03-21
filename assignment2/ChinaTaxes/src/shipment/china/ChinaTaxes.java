package shipment.china;

import shipment.api.Shipment;
import shipment.api.TaxesCalculator;

public class ChinaTaxes implements TaxesCalculator {

    public double calculateTax(Shipment s) {
        double totalTaxes = 0.0;
        if(s.getProductType().equals("ELETRONICS")) {
            totalTaxes = s.getAmount() * s.getIndividualPrice() * 0.5;
        } else {
            totalTaxes = s.getAmount() * s.getIndividualPrice() * 0.3;
        }
        if(s.getAmount() >= 1000 || s.getAmount() * s.getIndividualPrice() >= 100_000) {
            totalTaxes -= totalTaxes*0.2;
        }
        return totalTaxes;
    }

    public String getCountry() {
        return "China";
    }
}
