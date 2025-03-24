package shipment.brazil;

import shipment.api.Shipment;
import shipment.api.TaxesCalculator;

public class BrazilTaxes implements TaxesCalculator {
    public double calculateTax(Shipment s) {
        double taxes = 0.0;

        // 40% of total shipment cost alone, or with shipment cost as well

        taxes = (s.getAmount() * s.getIndividualPrice() * 0.4) + s.getShipmentPrice();

        if(s.getProductType().equals("FOOD") && taxes > 10_000) {
            taxes -= (taxes-10_000) * 0.4;
        }

        return taxes;
    }

    public String getCountry() {
        return "Brazil";
    }
}
