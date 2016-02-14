package services;

import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.csv.CSVRecord;
import org.junit.Test;

import ca.concordia.soen6461.scrapping.services.CSVService;

public class CSVServiceTest {

	private final CSVService service = new CSVService();

	@Test
	public void openCsvInExcelSuccess() {
		String filePath = "/csv/forExcel.csv";
		service.openInDefaultApp(filePath);
		// FIXME - test do not validate anything - create others to validate exceptions
	}

	@Test
	public void loadCsvSuccess() {
		// String filePath = "/csv/https---play_google_com-store-apps-details-id=.csv";
		// String filePath = "/csv/fixed.csv";
		String filePath = "/csv/forExcel.csv";

		Iterable<CSVRecord> records = service.loadCsv(filePath, ';', true);
		for (CSVRecord record : records) {
			System.out.println(record);

			Map<String, String> map = record.toMap();
			for (Entry<String, String> entry : map.entrySet()) {
				System.out.println("\t\t>> " + entry.getKey() + ": " + entry.getValue());
			}
		}
		
		// FIXME - test do not validate anything
	}
}
