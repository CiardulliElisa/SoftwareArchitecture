package shipment.italy;

import shipment.api.Shipment;
import shipment.api.TaxesCalculator;

public class ItalyTaxes implements TaxesCalculator {
    public double calculateTax(Shipment s) {

        double total_price = s.getAmount()*s.getIndividualPrice();
        double taxes = 0.0;

        taxes = total_price*0.3;

        if(s.getIndividualPrice() > 500) {
            taxes += 5.00;
        }

        if(s.getProductType().equals("CLOTHES") && total_price < 50.000) {
            taxes -= taxes * 0.2;
        }

        return taxes;
    }

    public String getCountry() {
        return "Italy";
    }
}
