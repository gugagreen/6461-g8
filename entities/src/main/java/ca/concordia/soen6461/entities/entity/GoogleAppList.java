package ca.concordia.soen6461.entities.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="google")
@XmlAccessorType (XmlAccessType.FIELD)
public class GoogleAppList {

	@XmlElement(name = "Item")
	private List<GoogleApp> apps;

	public List<GoogleApp> getApps() {
		return apps;
	}

	public void setApps(List<GoogleApp> apps) {
		this.apps = apps;
	}
}
