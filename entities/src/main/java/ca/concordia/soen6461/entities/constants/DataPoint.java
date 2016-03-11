package ca.concordia.soen6461.entities.constants;

public enum DataPoint {

	SIZE_RANKING("sizeRanking"), DATE_DOWNLOADS("dateDownloads"), DOWNLOADS_RANKING("downloadsRanking");

	private String value;

	private DataPoint(String value) {
		this.value = value;
	}

	public static DataPoint getByValue(String value) {
		DataPoint point = null;
		if (value != null) {
			for (DataPoint dp : DataPoint.values()) {
				if (value.equals(dp.value)) {
					point = dp;
					break;
				}
			}
		}
		return point;
	}
}
