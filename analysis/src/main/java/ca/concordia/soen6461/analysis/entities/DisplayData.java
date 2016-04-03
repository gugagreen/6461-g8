package ca.concordia.soen6461.analysis.entities;

import java.math.BigDecimal;

public class DisplayData {

	private String title;
	private String[] columns;
	private BigDecimal[] values;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String[] getColumns() {
		return columns;
	}
	public void setColumns(String[] columns) {
		this.columns = columns;
	}
	public BigDecimal[] getValues() {
		return values;
	}
	public void setValues(BigDecimal[] values) {
		this.values = values;
	}
	
}
