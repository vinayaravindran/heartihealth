package com.discoveri.heartihealth.dto;

public class SymptomPrediction {
	private String timestamp;
	private int symptomValue;

	public SymptomPrediction() {
		
	}

	public SymptomPrediction(String timestamp, int symptomValue) {
		super();
		this.timestamp = timestamp;
		this.symptomValue = symptomValue;
	}

	public String getTimeStamp() {
		return timestamp;
	}

	public void setTimestamp(String date) {
		this.timestamp = date;
	}

	public int getSymptomValue() {
		return symptomValue;
	}

	public void setSymptomValue(int symptom) {
		this.symptomValue = symptom;
	}

}
