package ca.concordia.soen6461.scrapping.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.csv.CSVRecord;

import com.thoughtworks.xstream.XStream;

public class XmlService {

	public static void main(String[] args) {
		XmlService service = new XmlService();

        try {
        	CSVService reader = new CSVService();
    		String filePath = "/csv/fixed.csv";

    		Iterable<CSVRecord> records = reader.loadCsv(filePath, ';', true);
    		
    		String xml = service.csvToXml(records);
            System.out.println(xml);

        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	public String csvToXml(Iterable<CSVRecord> records) {
		List<Map<String, String>> out = new ArrayList<Map<String, String>>();
		for (CSVRecord record : records) {
			Map<String, String> map = record.toMap();
			out.add(map);
		}

        XStream xstream = new XStream();
        return xstream.toXML(out);
	}

}
