package ca.concordia.soen6461.analysis.service.impl;

import ca.concordia.soen6461.analysis.entities.DisplayData;
import ca.concordia.soen6461.analysis.service.DisplayService;
import ca.concordia.soen6461.entities.entity.AnalysisResult;

public class TableDisplayService implements DisplayService {
	
	/**
	 * private constructor to enforce singleton
	 */
	private TableDisplayService() {
	}

	/**
	 * Singleton Holder to enforce load on first call of getInstance() in a thread-safe way, without need of manual
	 * synchronization.
	 */
	private static class SingletonHolder {
		private static final TableDisplayService INSTANCE = new TableDisplayService();
	}

	public static TableDisplayService getInstance() {
		return SingletonHolder.INSTANCE;
	}

	@Override
	public DisplayData buildDisplay(AnalysisResult result) {
		DisplayData displayData = new DisplayData();
		displayData.setTitle("dummy title"); // FIXME - set real title
		// FIXME - calculate columns names
		displayData.setColumns(result.getTitles());
		// FIXME - calculate columns values
		displayData.setValues(result.getResults());
		return displayData;
	}

}
