package com.discoveri.heartihealth.model;

import java.util.List;

public class AddressInfo {
	private int id;
	private String city;
	private String state;
	private String country;
	private String pincode;
	private List<Wearabledevicedata> Wearabledevicedata;
	private Memberinfo memberinfo;

	public AddressInfo(int id, String city, String state, String country, String pincode,
			List<com.discoveri.heartihealth.model.Wearabledevicedata> wearabledevicedata, Memberinfo memberinfo) {
		super();
		this.id = id;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
		Wearabledevicedata = wearabledevicedata;
		this.memberinfo = memberinfo;
	}

	public Memberinfo getMemberinfo() {
		return memberinfo;
	}

	public void setMemberinfo(Memberinfo memberinfo) {
		this.memberinfo = memberinfo;
	}

	public AddressInfo() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public List<Wearabledevicedata> getWearabledevicedata() {
		return Wearabledevicedata;
	}

	public void setWearabledevicedata(List<Wearabledevicedata> wearabledevicedata) {
		Wearabledevicedata = wearabledevicedata;
	}

}
