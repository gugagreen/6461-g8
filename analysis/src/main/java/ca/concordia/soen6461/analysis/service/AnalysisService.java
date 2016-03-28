package ca.concordia.soen6461.analysis.service;

import ca.concordia.soen6461.entities.constants.DataPoint;
import ca.concordia.soen6461.entities.entity.AnalysisResult;
import ca.concordia.soen6461.entities.entity.GoogleAppList;

public interface AnalysisService {

	/**
	 * Load scrapped data from default location.
	 * @return	List of scrapped data encapsulated into java object.
	 */
	GoogleAppList viewScrappedData();
	
	/**
	 * Performs analysis of existing apps.
	 * @param selectedPoint
	 * @return	The {@link AnalysisResult}.
	 */
	AnalysisResult performAnalysis(final DataPoint selectedPoint);
	
	/**
	 * Triggers calculation of points average.
	 * @param selectedPoint	The current selected dataPoint
	 */
	void calculateAverage(final DataPoint selectedPoint);
}
