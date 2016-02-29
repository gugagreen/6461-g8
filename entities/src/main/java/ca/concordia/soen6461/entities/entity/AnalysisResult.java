package ca.concordia.soen6461.entities.entity;

import java.math.BigDecimal;

public class AnalysisResult {
	
	private String[] titles;
	private BigDecimal[] scores;
	
	public String[] getTitles() {
		return titles;
	}
	public void setTitles(String[] titles) {
		this.titles = titles;
	}
	public BigDecimal[] getScores() {
		return scores;
	}
	public void setScores(BigDecimal[] scores) {
		this.scores = scores;
	}

	// FIXME - add fields
}
