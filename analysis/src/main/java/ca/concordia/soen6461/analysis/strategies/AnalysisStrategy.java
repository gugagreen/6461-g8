package ca.concordia.soen6461.analysis.strategies;

import ca.concordia.soen6461.entities.entity.AnalysisResult;
import ca.concordia.soen6461.entities.entity.GoogleAppList;

public interface AnalysisStrategy {

	AnalysisResult performAnalysis(GoogleAppList apps);
}
