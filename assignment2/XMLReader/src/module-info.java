import shipment.api.ShipmentReader;
import shipment.xml.XMLReader;

module shipment.xml.XMLReader {
    requires ShipmentAPI;

    provides ShipmentReader with XMLReader;
}