package ca.concordia.soen6461.analysis.service;

import ca.concordia.soen6461.analysis.entities.DisplayData;
import ca.concordia.soen6461.entities.entity.AnalysisResult;

public interface DisplayService {

	DisplayData buildDisplay(AnalysisResult result);
}
