import shipment.api.Shipment;
import shipment.api.ShipmentReader;
import shipment.csv.CVSReader;

module shipment.csv.CVSReader {
    requires ShipmentAPI;

    provides ShipmentReader with CVSReader;
}