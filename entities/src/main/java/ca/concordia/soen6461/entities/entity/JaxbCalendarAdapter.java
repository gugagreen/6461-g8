package ca.concordia.soen6461.entities.entity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class JaxbCalendarAdapter extends XmlAdapter<String, Calendar> {
	
	public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd MMMM yyyy");

	@Override
	public Calendar unmarshal(String v) throws Exception {
		Calendar cal = Calendar.getInstance();
		cal.setTime(DATE_FORMAT.parse(v));
		return cal;
	}

	@Override
	public String marshal(Calendar v) throws Exception {
		return DATE_FORMAT.format(v.getTime());
	}

}
