package ca.concordia.soen6461.scrapping.services;

import java.awt.Desktop;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URISyntaxException;
import java.net.URL;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class CSVService {

	public void openInDefaultApp(final String path) {
		try {
			URL url = CSVService.class.getResource(path);
			File file = new File(url.toURI());
			Desktop.getDesktop().edit(file);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

	public Iterable<CSVRecord> loadCsv(final String path, final char delimiter, final boolean hasHeader) {
		try {
			InputStream is = CSVService.class.getResourceAsStream(path);
			Reader in = new InputStreamReader(is);
			CSVFormat format = CSVFormat.EXCEL.withDelimiter(delimiter);
			if (hasHeader) {
				format = format.withHeader();
			}

			return format.parse(in);
		} catch (IOException e) {
			// FIXME - treat exception
			e.printStackTrace();
			return null;
		}
	}
	
	public File[] listAllCsv(final String folder) {
		File dir = new File(folder);
		
		return dir.listFiles(new FilenameFilter() {
		    @Override
		    public boolean accept(File dir, String name) {
		        return name.endsWith(".csv");
		    }
		});
	}

}
