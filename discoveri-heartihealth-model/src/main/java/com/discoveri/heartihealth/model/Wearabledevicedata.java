package com.discoveri.heartihealth.model;

import java.util.Date;

public class Wearabledevicedata {
	private int id;
	private int thalach;
	private int slope;
	private Date date;
	private AddressInfo addressinfo;

	public Wearabledevicedata(int id, int thalach, int slope, Date date, AddressInfo addressinfo) {
		super();
		this.id = id;
		this.thalach = thalach;
		this.slope = slope;
		this.date = date;
		this.addressinfo = addressinfo;
	}

	public AddressInfo getAddressinfo() {
		return addressinfo;
	}

	public void setAddressinfo(AddressInfo addressinfo) {
		this.addressinfo = addressinfo;
	}

	public Wearabledevicedata() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getThalach() {
		return thalach;
	}

	public void setThalach(int thalach) {
		this.thalach = thalach;
	}

	public int getSlope() {
		return slope;
	}

	public void setSlope(int slope) {
		this.slope = slope;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
