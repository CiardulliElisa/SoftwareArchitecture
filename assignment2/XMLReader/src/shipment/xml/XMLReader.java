package shipment.xml;

import shipment.api.Shipment;
import shipment.api.ShipmentReader;

import java.util.List;

public class XMLReader implements ShipmentReader {
    public List<Shipment> readFile(String filepath) {
        return List.of();
    }

    public String getFileType() {
        return "";
    }
}
