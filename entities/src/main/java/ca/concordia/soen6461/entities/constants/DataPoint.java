package ca.concordia.soen6461.entities.constants;

import java.util.Set;
import java.util.TreeSet;

public enum DataPoint {

	SCORE, TITLE, DATE_PUBLISHED, NUM_DOWNLOADS, CONTENT_RATING;

	public static Set<DataPoint> toDataPoints(String[] pointsString) {
		Set<DataPoint> dataPoints = new TreeSet<DataPoint>();
		for (String point : pointsString) {
			if (point != null) {
				for (DataPoint dp : DataPoint.values()) {
					if (point.equals(dp.name())) {
						dataPoints.add(dp);
					}
				}
			}
		}
		
		return dataPoints;
	}
}
