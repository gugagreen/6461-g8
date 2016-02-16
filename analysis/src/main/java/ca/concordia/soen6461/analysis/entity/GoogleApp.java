package ca.concordia.soen6461.analysis.entity;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class GoogleApp {

	private String title;
	private String developer;
	private BigDecimal price;
	private int installs;
	
	public String getTitle() {
		return title;
	}
	@XmlElement
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDeveloper() {
		return developer;
	}
	@XmlElement
	public void setDeveloper(String developer) {
		this.developer = developer;
	}
	public BigDecimal getPrice() {
		return price;
	}
	@XmlElement
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public int getInstalls() {
		return installs;
	}
	@XmlElement
	public void setInstalls(int installs) {
		this.installs = installs;
	}
	
	
}
