import shipment.api.Shipment;
import shipment.api.ShipmentReader;
import shipment.api.TaxesCalculator;

module shipment.main.ShipmentFileProcessor {
    requires ShipmentAPI;

    uses TaxesCalculator;
    uses ShipmentReader;
    uses Shipment;
}