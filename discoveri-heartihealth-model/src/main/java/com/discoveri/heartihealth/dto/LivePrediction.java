package com.discoveri.heartihealth.dto;

import java.util.ArrayList;
import java.util.List;

public class LivePrediction {
	
	private String symptomType;
	private int todayPredictionSymptomValue;
	private int variation;
	private boolean up;
	private List<SymptomPrediction> symptomPrediction = new ArrayList<>();
	
	public LivePrediction() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public LivePrediction(String symptomType, int todayPredictionSymptomValue, int variation, boolean up,
			List<SymptomPrediction> symptomPrediction) {
		super();
		this.symptomType = symptomType;
		this.todayPredictionSymptomValue = todayPredictionSymptomValue;
		this.variation = variation;
		this.up = up;
		this.symptomPrediction = symptomPrediction;
	}


	public String getSymptomType() {
		return symptomType;
	}
	public void setSymptomType(String symptomType) {
		this.symptomType = symptomType;
	}
	
	public List<SymptomPrediction> getSymptomPrediction() {
		return symptomPrediction;
	}
	public void setSymptomPrediction(List<SymptomPrediction> symptomPrediction) {
		this.symptomPrediction = symptomPrediction;
	}


	public int getTodayPredictionSymptomValue() {
		return todayPredictionSymptomValue;
	}


	public void setTodayPredictionSymptomValue(int todayPredictionSymptomValue) {
		this.todayPredictionSymptomValue = todayPredictionSymptomValue;
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
