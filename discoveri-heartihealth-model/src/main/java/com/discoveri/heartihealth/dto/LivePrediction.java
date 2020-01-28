package com.discoveri.heartihealth.dto;

import java.util.ArrayList;
import java.util.List;

public class LivePrediction {
	
	private String symptomType;
	private int todayPredictionCount;
	private List<SymptomPrediction> symptomPrediction = new ArrayList<>();
	
	public LivePrediction() {
		// TODO Auto-generated constructor stub
	}
	
	
	public LivePrediction(String symptomType, int todayPredictionCount, List<SymptomPrediction> symptomPrediction) {
		super();
		this.symptomType = symptomType;
		this.todayPredictionCount = todayPredictionCount;
		this.symptomPrediction = symptomPrediction;
	}
	public String getSymptomType() {
		return symptomType;
	}
	public void setSymptomType(String symptomType) {
		this.symptomType = symptomType;
	}
	public int getTodayPredictionCount() {
		return todayPredictionCount;
	}
	public void setTodayPredictionCount(int todayPredictionCount) {
		this.todayPredictionCount = todayPredictionCount;
	}
	public List<SymptomPrediction> getSymptomPrediction() {
		return symptomPrediction;
	}
	public void setSymptomPrediction(List<SymptomPrediction> symptomPrediction) {
		this.symptomPrediction = symptomPrediction;
	}
	
	
	

}
