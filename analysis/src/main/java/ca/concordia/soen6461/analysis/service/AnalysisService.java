package ca.concordia.soen6461.analysis.service;

import ca.concordia.soen6461.entities.constants.DataPoint;
import ca.concordia.soen6461.entities.constants.Strategy;
import ca.concordia.soen6461.entities.entity.AnalysisResult;
import ca.concordia.soen6461.entities.entity.GoogleAppList;

public interface AnalysisService {

	AnalysisResult performAnalysis(final GoogleAppList apps, final DataPoint selectedPoint, final Strategy strategy);
}
