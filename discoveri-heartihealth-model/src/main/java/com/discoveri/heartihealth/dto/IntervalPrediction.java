package com.discoveri.heartihealth.dto;

public class IntervalPrediction {
	private String interval; 
	private int predicted;
	private int cured;

	public IntervalPrediction() {
		// TODO Auto-generated constructor stub
	}

	public IntervalPrediction(String interval,int predicted, int cured) {
		super();
		this.interval = interval;
		
		this.predicted = predicted;
		this.cured = cured;
	}

	public String getInterval() {
		return interval;
	}

	public void setInterval(String interval) {
		this.interval = interval;
	}

	public int getPredicted() {
		return predicted;
	}

	public void setPredicted(int predicted) {
		this.predicted = predicted;
	}

	public int getCured() {
		return cured;
	}

	public void setCured(int cured) {
		this.cured = cured;
	}
}
