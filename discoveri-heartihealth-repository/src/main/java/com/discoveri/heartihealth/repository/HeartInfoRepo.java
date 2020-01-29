package com.discoveri.heartihealth.repository;

import java.util.List;

import com.discoveri.heartihealth.dto.CardioArrestDetection;
import com.discoveri.heartihealth.dto.GetTotalPredictionByPeriod;
import com.discoveri.heartihealth.dto.IntervalPrediction;
import com.discoveri.heartihealth.dto.LivePrediction;
import com.discoveri.heartihealth.dto.SymptomPrediction;
import com.discoveri.heartihealth.exceptions.HeartiExceptions;

public interface HeartInfoRepo {

	List<IntervalPrediction> weeklyReport() throws HeartiExceptions;

	List<IntervalPrediction> yearlyPredictions() throws HeartiExceptions;

	List<IntervalPrediction> monthlyReport() throws HeartiExceptions;
	
	List<SymptomPrediction> getChestPainDetection(String memberid);
	
	List<SymptomPrediction> getBloodPressureDetection(String memberid);
	
	List<SymptomPrediction> getCholesterolDetection(String memberid);
	
	List<LivePrediction> getLivePrediction(String memberid);
	
	LivePrediction getLivePredictionBySymptom(String memberid,String symptomType);
	
	
	List<CardioArrestDetection> totalCardioArrestDetection(String memberid);
	
	List<GetTotalPredictionByPeriod> getTotaPredictionByPeriod(String interval);
	
	List<GetTotalPredictionByPeriod> getTotalPredictionByWeekly();
	
	List<GetTotalPredictionByPeriod> getTotalPredictionByMonthly();
	
	List<GetTotalPredictionByPeriod> getTotalPredictionByYearly();
	
	int getPredictionOfChestPainValueByDay(String memberid, int curDay);
	int getPredictionOfBloodPressureByDay(String memberid,int curDay);
	int getPredictionOfCholesterolByDay(String memberid,int curDay);
}
