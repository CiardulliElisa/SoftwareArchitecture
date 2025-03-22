package shipment.xml;

import shipment.api.Shipment;
import shipment.api.ShipmentReader;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XMLReader implements ShipmentReader {
    public List<Shipment> readFile(String filepath) {
        List<Shipment> shipmentList = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filepath)))) {
            String line;
            while((line = br.readLine()) != null) {
                if(line.equals("<shipments>") || line.equals("</shipments>")) {
                    continue;
                }

                Shipment shipment = new Shipment();
                shipmentList.add(shipment);

                Pattern pattern = Pattern.compile("\"(.*?)\"");
                Matcher matcher = pattern.matcher(line);

                List<String> shipmentValues = new ArrayList<>();

                while(matcher.find()) {
                    shipmentValues.add(matcher.group(1));
                }

                shipment.setProductName(shipmentValues.get(0));
                shipment.setProductType(shipmentValues.get(1));
                shipment.setAmount(Integer.valueOf(shipmentValues.get(2)));
                shipment.setIndividualPrice(Double.valueOf(shipmentValues.get(3)));
                shipment.setShipmentPrice(Double.valueOf(shipmentValues.get(4)));
                shipment.setCountry(shipmentValues.get(5));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return shipmentList;
    }

    public String getFileType() {

        return "xml";
    }
}
