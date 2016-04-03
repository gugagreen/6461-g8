package ca.concordia.soen6461.analysis.strategies;

import ca.concordia.soen6461.analysis.strategies.impl.DateDownloadsStrategy;
import ca.concordia.soen6461.analysis.strategies.impl.DownloadsRankingStrategy;
import ca.concordia.soen6461.analysis.strategies.impl.SizeRankingStrategy;
import ca.concordia.soen6461.entities.constants.DataPoint;

public class StrategyPool {
	
	public static AnalysisStrategy loadStrategy(DataPoint dataPoint) {
		// XXX - maybe use reflection to load strategies on the fly instead of a switch
		AnalysisStrategy strategy = null;
		
		switch (dataPoint) {
		case DATE_DOWNLOADS:
			strategy = new DateDownloadsStrategy();
			break;
		case DOWNLOADS_RANKING:
			strategy = new DownloadsRankingStrategy();
			break;
		case SIZE_RANKING:
			strategy = new SizeRankingStrategy();
			break;
		default:
			break;
		}
		return strategy;
	}
}
