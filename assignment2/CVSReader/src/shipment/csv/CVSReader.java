package shipment.csv;

import shipment.api.Shipment;
import shipment.api.ShipmentReader;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CVSReader implements ShipmentReader {

    public List<Shipment> readFile(String filepath) {
        List<Shipment> shipmentList = new ArrayList<Shipment>();
        try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filepath)))) {
            String line;
            while((line = br.readLine()) != null) {
                Shipment shipment = new Shipment();
                shipmentList.add(shipment);
                String[] array = line.split(";");
                shipment.setProductName(array[0]);
                shipment.setProductType(array[1]);
                shipment.setAmount(Integer.valueOf(array[2]));
                shipment.setIndividualPrice(Double.valueOf(array[3]));
                shipment.setShipmentPrice(Double.valueOf(array[4]));
                shipment.setCountry(array[5]);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return shipmentList;
    }

    public String getFileType() {
        return "csv";
    }
}
