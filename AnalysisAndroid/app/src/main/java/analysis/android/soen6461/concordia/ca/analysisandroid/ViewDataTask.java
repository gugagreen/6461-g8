package analysis.android.soen6461.concordia.ca.analysisandroid;

import android.os.AsyncTask;
import android.util.Log;
import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import ca.concordia.soen6461.entities.entity.GoogleApp;
import ca.concordia.soen6461.entities.entity.GoogleAppList;

/**
 * Created by i840044 on 2016-04-02.
 */
public class ViewDataTask extends AsyncTask<String, String, String> {

    @Override
    protected String doInBackground(String... args) {
        makeGetRequest();
        return null;
    }

    private void makeGetRequest() {
        GoogleAppList apps = null;
        try {
            String path = "http://10.0.2.2:8080/testXml";
            //String path = "http://localhost:8080/testXml";
            Log.d(">> makeGetRequest: ", path);
            URL url = new URL(path);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            try {
                InputStream in = connection.getInputStream();
                //Scanner s = new Scanner(in).useDelimiter("\\A");
                //String result = s.hasNext() ? s.next() : "";
                //Log.d(">> result: ", result);

//                BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
//                apps = marshallerService.unmarshall(GoogleAppList.class, reader);
//                for (GoogleApp app : apps.getApps()) {
//                    Log.d(">> result: ", app.getTitle());
//                }

                apps = parse(in);

                for (GoogleApp app : apps.getApps()) {
                    Log.d(">> result: ", app.getTitle());
                }
            } finally{
                connection.disconnect();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // see http://developer.android.com/training/basics/network-ops/xml.html
    private GoogleAppList parse(InputStream in) throws XmlPullParserException, IOException {
        try {
            XmlPullParser parser = Xml.newPullParser();
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(in, null);
            parser.nextTag();
            return readGoogleAppList(parser);
        } finally {
            in.close();
        }
    }

    private GoogleAppList readGoogleAppList(XmlPullParser parser) throws XmlPullParserException, IOException {
        GoogleAppList apps = new GoogleAppList();

        parser.require(XmlPullParser.START_TAG, null, "google");

        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            // Starts by looking for the entry tag
            if (name.equals("Item")) {
                if (apps.getApps() == null) {
                    apps.setApps(new ArrayList<GoogleApp>());
                }
                apps.getApps().add(readItem(parser));
            } else {
                skip(parser);
            }
        }

        return apps;
    }

    private GoogleApp readItem(XmlPullParser parser) throws XmlPullParserException, IOException {
        GoogleApp app = new GoogleApp();
        parser.require(XmlPullParser.START_TAG, null, "Item");

        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            if (name.equals("contentRating")) {
                app.setContentRating(readStringTag(parser, "contentRating"));
            } else if (name.equals("datePublished")) {
                String dp = readStringTag(parser, "datePublished");
                try {
                    app.setDatePublished(string2Calendar(dp));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (name.equals("numDownloads")) {
                app.setNumDownloads(readStringTag(parser, "numDownloads"));
            } else if (name.equals("score")) {
                app.setScore(new BigDecimal(readStringTag(parser, "score")));
            } else if (name.equals("title")) {
                app.setTitle(readStringTag(parser, "title"));
            } else {
                skip(parser);
            }
        }

        return app;
    }

    private String readStringTag(XmlPullParser parser, String tagName) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, tagName);
        String title = readText(parser);
        parser.require(XmlPullParser.END_TAG, null, tagName);
        return title;
    }

    private String readText(XmlPullParser parser) throws IOException, XmlPullParserException {
        String result = "";
        if (parser.next() == XmlPullParser.TEXT) {
            result = parser.getText();
            parser.nextTag();
        }
        return result;
    }

    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd MMMM yyyy");

    public Calendar string2Calendar(String v) throws Exception {
        Calendar cal = Calendar.getInstance();
        cal.setTime(DATE_FORMAT.parse(v));
        return cal;
    }

    private void skip(XmlPullParser parser) throws XmlPullParserException, IOException {
        if (parser.getEventType() != XmlPullParser.START_TAG) {
            throw new IllegalStateException();
        }
        int depth = 1;
        while (depth != 0) {
            switch (parser.next()) {
                case XmlPullParser.END_TAG:
                    depth--;
                    break;
                case XmlPullParser.START_TAG:
                    depth++;
                    break;
            }
        }
    }
}
