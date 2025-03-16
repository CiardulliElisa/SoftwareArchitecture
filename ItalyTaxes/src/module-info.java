import shipment.italy.ItalyTaxes;
import shipment.api.TaxesCalculator;

module shipment.italy.ItalyTaxes {
    requires ShipmentAPI;

    provides TaxesCalculator with ItalyTaxes;
}