package com.discoveri.heartihealth.dto;

public class GetTotalPredictionByPeriod {
	
	private String interval;
	private int totalPrediction;
	private int variation;
	private boolean up;
	
	
	
	public GetTotalPredictionByPeriod() {
		
	}
	
	public GetTotalPredictionByPeriod(String interval, int totalPrediction, int variation, boolean up) {
		super();
		this.interval = interval;
		this.totalPrediction = totalPrediction;
		this.variation = variation;
		this.up = up;
	}
	
	public String getInterval() {
		return interval;
	}
	public void setInterval(String interval) {
		this.interval = interval;
	}
	public int getTotalPrediction() {
		return totalPrediction;
	}
	public void setTotalPrediction(int totalPrediction) {
		this.totalPrediction = totalPrediction;
	}
	public int getVariation() {
		return variation;
	}
	public void setVariation(int variation) {
		this.variation = variation;
	}
	public boolean isUp() {
		return up;
	}
	public void setUp(boolean up) {
		this.up = up;
	}
	
	

}
