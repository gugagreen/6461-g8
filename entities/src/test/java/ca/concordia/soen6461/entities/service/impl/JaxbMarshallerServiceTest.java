package ca.concordia.soen6461.entities.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Calendar;

import org.junit.Test;

import ca.concordia.soen6461.entities.entity.GoogleApp;
import ca.concordia.soen6461.entities.entity.GoogleAppList;
import ca.concordia.soen6461.entities.entity.JaxbCalendarAdapter;
import ca.concordia.soen6461.entities.service.MarshallerService;

public class JaxbMarshallerServiceTest {
	public static final String TEST_FILE_PATH = "/jaxbGoogleAppTest.xml";

	MarshallerService<GoogleAppList> service = new JaxbMarshallerService<>();

	@Test
	public void testUnmarshallingSuccess() throws FileNotFoundException, ParseException {
		File testFile = new File(getClass().getResource(TEST_FILE_PATH).getFile());

		FileReader reader = new FileReader(testFile);
		GoogleAppList appList = service.unmarshall(GoogleAppList.class, reader);
		assertNotNull(appList);
		assertNotNull(appList.getApps());
		assertEquals(4, appList.getApps().size());
		
		GoogleApp app = appList.getApps().get(0);
		GoogleApp stub = getStubApp();

		assertEquals(stub.getId(), app.getId());
		assertEquals(stub.getScore(), app.getScore());
		assertEquals(stub.getTitle(), app.getTitle());
		assertEquals(stub.getDatePublished(), app.getDatePublished());
		assertEquals(stub.getNumDownloads(), app.getNumDownloads());
		assertEquals(stub.getContentRating(), app.getContentRating());
	}

	private GoogleApp getStubApp() {
		// <Item id="1">
		// <score>4.5</score>
		// <title>Instagram – Android Apps on Google Play</title>
		// <datePublished>12 February 2016</datePublished>
		// <numDownloads>500,000,000 - 1,000,000,000</numDownloads>
		// <contentRating>Teen</contentRating>
		// </Item>
		GoogleApp stub = new GoogleApp();
		stub.setId(1);
		stub.setScore(new BigDecimal("4.5"));
		stub.setTitle("Instagram – Android Apps on Google Play");
		try {
			Calendar cal = Calendar.getInstance();
			cal.setTime(JaxbCalendarAdapter.DATE_FORMAT.parse("12 February 2016"));
			stub.setDatePublished(cal);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		stub.setNumDownloads("500,000,000 - 1,000,000,000");
		stub.setContentRating("Teen");
		
		return stub;
	}
}
