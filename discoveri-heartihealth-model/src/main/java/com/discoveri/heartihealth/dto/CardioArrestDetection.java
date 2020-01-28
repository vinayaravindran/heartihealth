package com.discoveri.heartihealth.dto;

public class CardioArrestDetection {

	private String timestamp;
	private boolean isAgeBelowThirty;
	private boolean isMale;

	public String getTimestamp() {
		return timestamp;
	}

	public CardioArrestDetection() {
		// TODO Auto-generated constructor stub
	}

	public CardioArrestDetection(String timestamp, boolean isAgeBelowThirty, boolean isMale) {
		super();
		this.timestamp = timestamp;
		this.isAgeBelowThirty = isAgeBelowThirty;
		this.isMale = isMale;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public boolean isAgeBelowThirty() {
		return isAgeBelowThirty;
	}

	public void setAgeBelowThirty(boolean isAgeBelowThirty) {
		this.isAgeBelowThirty = isAgeBelowThirty;
	}

	public boolean isMale() {
		return isMale;
	}

	public void setMale(boolean isMale) {
		this.isMale = isMale;
	}

}
