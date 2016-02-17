import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;

import org.jsoup.Jsoup;
import org.jsoup.helper.StringUtil;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import ca.concordia.soen6461.entities.entity.GoogleApp;
import ca.concordia.soen6461.entities.entity.GoogleAppList;
import ca.concordia.soen6461.entities.entity.JaxbCalendarAdapter;
import ca.concordia.soen6461.entities.service.MarshallerService;
import ca.concordia.soen6461.entities.service.impl.JaxbMarshallerService;

public class ExtractData {

	private static final String DIV_CONTENT = "div.content";
	private static final String TITLE = "title";
	private static final String DIV_SCORE = "div.score";
	private static final String NUM_DOWNLOADS = "[itemprop=numDownloads]";
	private static final String DATE_PUBLISHED = "[itemprop=datePublished]";
	private static final String AGE_RANGE = "[itemprop=ageRange]";
	private static final String CONTENT_RATING = "[itemprop=contentRating]";
	
	private MarshallerService<GoogleAppList> marshaller = new JaxbMarshallerService<>();

	public String readPages(String address, int sCORE_BOX, int pUBLISH_DATE_BOX, int tITLE_BOX, int nU_DOWNLOAD_BOX,
			int aGE_RANGE_BOX) throws Exception {

		String result = readFile(address);

		return result;
	}

	public String readFile(String address) throws Exception {
		String result = "";

		BufferedReader br = null;

		try {
			String sCurrentLine;

			br = new BufferedReader(new FileReader(address));

			GoogleAppList appList = new GoogleAppList();
			appList.setApps(new ArrayList<GoogleApp>());
			while ((sCurrentLine = br.readLine()) != null) {
				GoogleApp app = readPageData(sCurrentLine);
				if (app != null) {
					appList.getApps().add(app);
				}
			}

			result = "Number of Items::" + appList.getApps().size();
			// FIXME - get file path from properties
			FileWriter writer = new FileWriter("D:\\file123.xml");
			
			marshaller.marshall(appList, writer);

			System.out.println("File saved!");

		} catch (IOException e) {
			e.printStackTrace();
			result = "false";
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
				result = "false";
			}
		}

		return result;

	}

	private GoogleApp readPageData(String url) {
		GoogleApp app = null;
		Document doc = getDocument(url);

		String score = getDocContent(doc, DIV_SCORE);
		String title = getDocContent(doc, TITLE);

		if (score != null && title != null) {
			app = new GoogleApp();

			app.setScore(new BigDecimal(score));
			app.setTitle(title);

			Elements items = doc.select(DIV_CONTENT);

			for (Element item : items) {
				String numDownloads = getInnerContent(item, NUM_DOWNLOADS);
				if (numDownloads != null) {
					app.setNumDownloads(numDownloads);
				}

				String datePublished = getInnerContent(item, DATE_PUBLISHED);
				if (datePublished != null) {
					try {
						Calendar cal = Calendar.getInstance();
						cal.setTime(JaxbCalendarAdapter.DATE_FORMAT.parse(datePublished));
						app.setDatePublished(cal);
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}

				String ageRange = getInnerContent(item, AGE_RANGE);
				if (ageRange != null) {
					// app.set - FIXME - add age range to entity
				}

				String contentRating = getInnerContent(item, CONTENT_RATING);
				if (contentRating != null) {
					app.setContentRating(contentRating);
				}

			}
		}
		return app;

	}

	private Document getDocument(String url) {
		Document doc = null;
		try {
			System.out.println("\nSending 'GET' request to URL : " + url); // FIXME - remove sysout
			doc = Jsoup.connect(url).timeout(5000).get();
		} catch (IOException e) {
			// FIXME - tread exception properly
			e.printStackTrace();
		}
		return doc;
	}

	private String getDocContent(Document doc, String cssQuery) {
		String content = null;
		Elements elements = doc.select(cssQuery);
		if (elements != null && elements.first() != null && !StringUtil.isBlank(elements.first().text())) {
			content = elements.first().text();
		}

		return content;
	}

	private String getInnerContent(Element item, String cssQuery) {
		String content = null;
		Elements elements = item.select(cssQuery);
		if (elements != null && elements.text() != null && !StringUtil.isBlank(elements.text())) {
			content = elements.text();
		}
		return content;
	}
}
