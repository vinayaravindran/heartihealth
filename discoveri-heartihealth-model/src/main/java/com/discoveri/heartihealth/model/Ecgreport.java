package com.discoveri.heartihealth.model;

import java.util.Date;

public class Ecgreport {
	private int ecgId;
	private Date date;
	private int restecg;

	public Ecgreport() {
		// TODO Auto-generated constructor stub
	}

	public int getEcgId() {
		return ecgId;
	}

	public void setEcgId(int ecgId) {
		this.ecgId = ecgId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getRestecg() {
		return restecg;
	}

	public void setRestecg(int restecg) {
		this.restecg = restecg;
	}

}
