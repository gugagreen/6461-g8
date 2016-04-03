package ca.concordia.soen6461.analysis.entities;

import ca.concordia.soen6461.analysis.service.DisplayService;
import ca.concordia.soen6461.analysis.service.impl.GraphDisplayService;
import ca.concordia.soen6461.analysis.service.impl.TableDisplayService;

public enum Display {

	GRAPH("graph", GraphDisplayService.getInstance()), TABLE("table", TableDisplayService.getInstance());
	
	private String value;
	private DisplayService service;

	private Display(String value, DisplayService service) {
		this.value = value;
		this.service = service;
	}

	public String getValue() {
		return value;
	}

	public DisplayService getService() {
		return service;
	}

	public static DisplayService getServiceByValue(String value) {
		DisplayService service = null;
		if (value != null) {
			for (Display dp : Display.values()) {
				if (value.equalsIgnoreCase(dp.value)) {
					service = dp.service;
					break;
				}
			}
		}
		return service;
	}
}
