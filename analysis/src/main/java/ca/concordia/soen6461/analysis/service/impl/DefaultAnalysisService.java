package ca.concordia.soen6461.analysis.service.impl;

import java.math.BigDecimal;

import ca.concordia.soen6461.analysis.service.AnalysisService;
import ca.concordia.soen6461.entities.constants.DataPoint;
import ca.concordia.soen6461.entities.constants.Strategy;
import ca.concordia.soen6461.entities.entity.AnalysisResult;
import ca.concordia.soen6461.entities.entity.GoogleAppList;

public class DefaultAnalysisService implements AnalysisService {

	@Override
	public AnalysisResult performAnalysis(final GoogleAppList apps, final DataPoint selectedPoint,
			final Strategy strategy) {
		return dummy(apps);
	}
	
	// FIXME - create real analysis loader
	private AnalysisResult dummy(final GoogleAppList apps) {
		AnalysisResult result = new AnalysisResult();
		result.setTitles(new String[] {"a", "b"});
		result.setScores(new BigDecimal[] {new BigDecimal(3.2), new BigDecimal(4.4)});
		return result;
	}

}
