package ca.concordia.soen6461.analysis.service.impl;

import ca.concordia.soen6461.analysis.service.AnalysisService;
import ca.concordia.soen6461.analysis.strategies.impl.SizeRankingStrategy;
import ca.concordia.soen6461.analysis.util.Key;
import ca.concordia.soen6461.analysis.util.PropsMng;
import ca.concordia.soen6461.entities.constants.DataPoint;
import ca.concordia.soen6461.entities.entity.AnalysisResult;
import ca.concordia.soen6461.entities.entity.GoogleAppList;

public class DefaultAnalysisService implements AnalysisService {

	/**
	 * private constructor to enforce singleton
	 */
	private DefaultAnalysisService() {
	}

	/**
	 * Singleton Holder to enforce load on first call of getInstance() in a thread-safe way, without need of manual
	 * synchronization.
	 */
	private static class SingletonHolder {
		private static final DefaultAnalysisService INSTANCE = new DefaultAnalysisService();
	}

	public static DefaultAnalysisService getInstance() {
		return SingletonHolder.INSTANCE;
	}

	@Override
	public AnalysisResult performAnalysis(final DataPoint selectedPoint) {
		GoogleAppList apps = getApps();
		// FIXME - load correct strategy
		SizeRankingStrategy strategy = new SizeRankingStrategy();
		return strategy.performAnalysis(apps);
	}

	@Override
	public GoogleAppList viewScrappedData() {
		return getApps();
	}

	@Override
	public void calculateAverage(DataPoint selectedPoint) {
		// TODO Auto-generated method stub
	}

	private GoogleAppList getApps() {
		// TODO - change to DAO
		return XmlFileService.getInstance().loadApps(PropsMng.get(Key.FILE_PATH));
	}

}
