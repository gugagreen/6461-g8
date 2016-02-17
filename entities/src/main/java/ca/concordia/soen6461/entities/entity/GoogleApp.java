package ca.concordia.soen6461.entities.entity;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name="Item")
public class GoogleApp {

	private int id;
	private BigDecimal score;
	private String title;
	private Calendar datePublished;
	private String numDownloads;
	private String contentRating;
	
	public int getId() {
		return id;
	}
	@XmlAttribute
	public void setId(int id) {
		this.id = id;
	}
	public BigDecimal getScore() {
		return score;
	}
	@XmlElement
	public void setScore(BigDecimal score) {
		this.score = score;
	}
	public String getTitle() {
		return title;
	}
	@XmlElement
	public void setTitle(String title) {
		this.title = title;
	}
	public Calendar getDatePublished() {
		return datePublished;
	}
	@XmlElement
	@XmlJavaTypeAdapter(JaxbCalendarAdapter.class)
	public void setDatePublished(Calendar datePublished) {
		this.datePublished = datePublished;
	}
	public String getNumDownloads() {
		return numDownloads;
	}
	@XmlElement
	public void setNumDownloads(String numDownloads) {
		this.numDownloads = numDownloads;
	}
	public String getContentRating() {
		return contentRating;
	}
	@XmlElement
	public void setContentRating(String contentRating) {
		this.contentRating = contentRating;
	}
	
}
