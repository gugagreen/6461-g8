package ca.concordia.soen6461.analysis.util;

import java.io.IOException;
import java.io.InputStream;

/**
 * Properties Manager utility class.
 */
public class PropsMng {

	private static final java.util.Properties PROPS = new java.util.Properties();
	
	static {
		try {
			InputStream inputStream = PropsMng.class.getClassLoader().getResourceAsStream("project.properties");
			PROPS.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String get(Key key) {
		return PROPS.getProperty(key.key);
	}
	
	public static String[] getList(Key key) {
		String commaSeparated = PROPS.getProperty(key.key);
		return commaSeparated.split(",");
	}
	
}

