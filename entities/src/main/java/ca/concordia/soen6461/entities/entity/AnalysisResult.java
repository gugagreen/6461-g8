package ca.concordia.soen6461.entities.entity;

import java.math.BigDecimal;

public class AnalysisResult {
	
	private String[] titles;
	private BigDecimal[] results;
	
	public AnalysisResult(int size) {
		this.titles = new String[size];
		this.results = new BigDecimal[size];
	}
	
	public String[] getTitles() {
		return titles;
	}
	public BigDecimal[] getResults() {
		return results;
	}
	
	public void addTitle(final String title, final int position) {
		titles[position] = title;
	}
	
	public void addResult(final BigDecimal result, final int position) {
		results[position] = result;
	}
}
