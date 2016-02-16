package ca.concordia.soen6461.analysis.service.impl;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;

import org.junit.Test;

import ca.concordia.soen6461.analysis.entity.GoogleApp;
import ca.concordia.soen6461.analysis.service.MarshallerService;

public class JaxbMarshallerServiceTest {
	public static final String TEST_FILE_PATH = "/jaxbGoogleAppTest.xml";
	
	MarshallerService<GoogleApp> service = new JaxbMarshallerService<>();

	@Test
	public void testUnmarshallingSuccess() throws FileNotFoundException {
		File testFile = new File(getClass().getResource(TEST_FILE_PATH).getFile());
		
		FileReader reader = new FileReader(testFile);
		GoogleApp app = service.unmarshall(GoogleApp.class, reader);
		assertNotNull(app);
		assertEquals("banana app", app.getTitle());
		assertEquals("banana.cia", app.getDeveloper());
		assertEquals(new BigDecimal("1.99"), app.getPrice());
		assertEquals(10000, app.getInstalls());
	}
}
