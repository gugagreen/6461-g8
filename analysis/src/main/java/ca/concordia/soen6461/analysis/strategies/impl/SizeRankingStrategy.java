package ca.concordia.soen6461.analysis.strategies.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;

import ca.concordia.soen6461.analysis.strategies.AnalysisStrategy;
import ca.concordia.soen6461.entities.entity.AnalysisResult;
import ca.concordia.soen6461.entities.entity.GoogleApp;
import ca.concordia.soen6461.entities.entity.GoogleAppList;

public class SizeRankingStrategy implements AnalysisStrategy {

	@Override
	public AnalysisResult performAnalysis(GoogleAppList apps) {
		AnalysisResult result = null;
		if (apps != null && apps.getApps() != null) {
			result = new AnalysisResult(apps.getApps().size());
			for (int i = 0; i < apps.getApps().size(); i++) {
				GoogleApp app = apps.getApps().get(i);
				BigDecimal score = app.getScore();
				BigDecimal size = numDownloadsToSize(app.getNumDownloads());
				
				result.addTitle(app.getTitle(), i);
				result.addResult(size.divide(score, 2, RoundingMode.HALF_UP), i);
				
				System.out.println(i + ") " + result.getTitles()[i] + "\t" + result.getResults()[i] + "\t" + score + "\t" + size);
			}
		}
		return result;
	}
	
	protected BigDecimal numDownloadsToSize(final String numDownloads) {
		String[] halves = numDownloads.split("-");
		long firstBound = Long.parseLong(halves[0].trim().replaceAll(",", ""));
		long lastBound = Long.parseLong(halves[1].trim().replaceAll(",", ""));
		return new BigDecimal((firstBound + lastBound) / 2.0);
	}

}
