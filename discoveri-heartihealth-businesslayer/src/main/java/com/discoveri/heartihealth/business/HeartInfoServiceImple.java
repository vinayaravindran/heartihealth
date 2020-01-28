package com.discoveri.heartihealth.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.discoveri.heartihealth.dto.CardioArrestDetection;
import com.discoveri.heartihealth.dto.IntervalPrediction;
import com.discoveri.heartihealth.dto.LivePrediction;
import com.discoveri.heartihealth.exceptions.HeartiExceptions;
import com.discoveri.heartihealth.repository.HeartInfoRepo;

@Service
public class HeartInfoServiceImple implements HeartInfoService {

	@Autowired
	public HeartInfoRepo heartInfoRepo;

	@Override
	public List<IntervalPrediction> weeklyReport() throws HeartiExceptions {
		 
		return heartInfoRepo.weeklyReport();
	}

	@Override
	public List<IntervalPrediction> yearlyReport() throws HeartiExceptions {
		 
		return heartInfoRepo.yearlyPredictions();
	}

	@Override
	public List<IntervalPrediction> monthlyReport() throws HeartiExceptions {

		return heartInfoRepo.monthlyReport();
	}

	@Override
	public List<CardioArrestDetection> totalCardioArrestDetection(String memberid) {
		// TODO Auto-generated method stub
		return heartInfoRepo.totalCardioArrestDetection(memberid);
	}

	@Override
	public List<LivePrediction> getLivePrediction(String memberid) {
		// TODO Auto-generated method stub
		return heartInfoRepo.getLivePrediction(memberid);
	}


	
}
