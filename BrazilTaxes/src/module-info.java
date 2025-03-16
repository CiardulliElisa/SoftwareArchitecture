import shipment.brazil.BrazilTaxes;
import shipment.api.TaxesCalculator;

module shipment.brazil.BrazilTaxes {
    requires ShipmentAPI;

    provides TaxesCalculator with BrazilTaxes;
}