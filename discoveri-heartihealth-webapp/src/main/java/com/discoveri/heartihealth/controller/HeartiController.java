package com.discoveri.heartihealth.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.discoveri.heartihealth.business.HeartInfoService;
import com.discoveri.heartihealth.dto.CardioArrestDetection;
import com.discoveri.heartihealth.dto.IntervalPrediction;
import com.discoveri.heartihealth.dto.LivePrediction;
import com.discoveri.heartihealth.exceptions.HeartiExceptions;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class HeartiController {

	@Autowired
	private HeartInfoService heartInfoService;

	@RequestMapping(value = "/weeklyReport", method = RequestMethod.GET)
	public ResponseEntity<List<IntervalPrediction>> weeklyReport() throws SQLException {
		try {
			List<IntervalPrediction> weeklypredication = heartInfoService.weeklyReport();
			if (weeklypredication == null) {
				return new ResponseEntity<List<IntervalPrediction>>(weeklypredication, HttpStatus.NOT_FOUND);
			} else
				return new ResponseEntity<List<IntervalPrediction>>(weeklypredication, HttpStatus.OK);
		} catch (HeartiExceptions e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = "/yearlyReport",method = RequestMethod.GET)
	public ResponseEntity<List<IntervalPrediction>> yearlyReport() throws SQLException {
		try {
			List<IntervalPrediction> yearlypredication = heartInfoService.weeklyReport();
			if (yearlypredication == null) {
				return new ResponseEntity<List<IntervalPrediction>>(yearlypredication, HttpStatus.NOT_FOUND);
			} else
				return new ResponseEntity<List<IntervalPrediction>>(yearlypredication, HttpStatus.OK);
		} catch (HeartiExceptions e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = "/intervalReport/{reportType}",method = RequestMethod.GET)
	public ResponseEntity<List<IntervalPrediction>> intervalReport(@PathVariable String reportType)
			throws SQLException {
		List<IntervalPrediction> intervalReport = null;
		try {

			if (reportType.equalsIgnoreCase("weeklyReport")) {
				intervalReport = heartInfoService.weeklyReport();
			} else if (reportType.equalsIgnoreCase("yearlyReport")) {
				intervalReport = heartInfoService.yearlyReport();
			} else if (reportType.equalsIgnoreCase("monthlyReport")) {
				intervalReport = heartInfoService.monthlyReport();
			}
			if (intervalReport == null) {
				return new ResponseEntity<List<IntervalPrediction>>(intervalReport, HttpStatus.NOT_FOUND);
			} else
				return new ResponseEntity<List<IntervalPrediction>>(intervalReport, HttpStatus.OK);
		} catch (HeartiExceptions e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = "/getTotalCardioArrestPrediction/{memberid}",method = RequestMethod.GET)

	public ResponseEntity<List<CardioArrestDetection>> getTotalCardioArrestPrediction(@PathVariable String memberid)
			throws SQLException {
		try {
			List<CardioArrestDetection> cardioArrestDetections = heartInfoService.totalCardioArrestDetection(memberid);
			if (cardioArrestDetections == null) {
				return new ResponseEntity<List<CardioArrestDetection>>(cardioArrestDetections, HttpStatus.NOT_FOUND);
			} else
				return new ResponseEntity<List<CardioArrestDetection>>(cardioArrestDetections, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = "/getTotalCardioArrestPrediction",method = RequestMethod.GET)

	public ResponseEntity<List<CardioArrestDetection>> getTotalCardioArrestPrediction()
			throws SQLException {
		try {
			List<CardioArrestDetection> cardioArrestDetections = heartInfoService.totalCardioArrestDetection(null);
			if (cardioArrestDetections == null) {
				return new ResponseEntity<List<CardioArrestDetection>>(cardioArrestDetections, HttpStatus.NOT_FOUND);
			} else
				return new ResponseEntity<List<CardioArrestDetection>>(cardioArrestDetections, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	@RequestMapping(value = "/livePredictions/{memberid}",method = RequestMethod.GET)

	public ResponseEntity<List<LivePrediction>> getLivePrediction(@PathVariable String memberid)
			throws SQLException {
		try {
			List<LivePrediction> livePredictions = heartInfoService.getLivePrediction(memberid);
			if (livePredictions == null) {
				return new ResponseEntity<List<LivePrediction>>(livePredictions, HttpStatus.NOT_FOUND);
			} else
				return new ResponseEntity<List<LivePrediction>>(livePredictions, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	@RequestMapping(value = "/livePredictions",method = RequestMethod.GET)

	public ResponseEntity<List<LivePrediction>> getLivePrediction()
			throws SQLException {
		try {
			List<LivePrediction> livePredictions = heartInfoService.getLivePrediction(null);
			if (livePredictions == null) {
				return new ResponseEntity<List<LivePrediction>>(livePredictions, HttpStatus.NOT_FOUND);
			} else
				return new ResponseEntity<List<LivePrediction>>(livePredictions, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}