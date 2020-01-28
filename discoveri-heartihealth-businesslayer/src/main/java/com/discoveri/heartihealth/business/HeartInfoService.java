package com.discoveri.heartihealth.business;

import java.util.List;

import com.discoveri.heartihealth.dto.CardioArrestDetection;
import com.discoveri.heartihealth.dto.IntervalPrediction;
import com.discoveri.heartihealth.dto.LivePrediction;
import com.discoveri.heartihealth.exceptions.HeartiExceptions;

public interface HeartInfoService {

	List<IntervalPrediction> weeklyReport() throws HeartiExceptions;

	List<IntervalPrediction> yearlyReport() throws HeartiExceptions;
	
	List<IntervalPrediction> monthlyReport() throws HeartiExceptions;
	
	List<CardioArrestDetection> totalCardioArrestDetection(String memberid) ;
	
	List<LivePrediction> getLivePrediction(String memberid);
	
	
}
