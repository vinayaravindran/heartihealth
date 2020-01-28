package com.discoveri.heartihealth.model;

import java.util.Date;

public class BloodTest {
	private int bloodId;
	private Date date;
	private int bloodpressure;
	private int fbs;
	private int thal;
	private int serumcholesterol;

	public BloodTest() {
		// TODO Auto-generated constructor stub
	}

	public int getBloodId() {
		return bloodId;
	}

	public void setBloodId(int bloodId) {
		this.bloodId = bloodId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getBloodpressure() {
		return bloodpressure;
	}

	public void setBloodpressure(int bloodpressure) {
		this.bloodpressure = bloodpressure;
	}

	public int getFbs() {
		return fbs;
	}

	public void setFbs(int fbs) {
		this.fbs = fbs;
	}

	public int getThal() {
		return thal;
	}

	public void setThal(int thal) {
		this.thal = thal;
	}

	public int getSerumcholesterol() {
		return serumcholesterol;
	}

	public void setSerumcholesterol(int serumcholesterol) {
		this.serumcholesterol = serumcholesterol;
	}

}
