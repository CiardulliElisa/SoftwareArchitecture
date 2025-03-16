import shipment.api.TaxesCalculator;
import shipment.china.ChinaTaxes;

module shipment.china.ChinaTaxes {
    requires ShipmentAPI;

    provides TaxesCalculator with ChinaTaxes;

}