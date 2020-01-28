package com.discoveri.heartihealth.model;

import java.util.Date;
import java.util.List;

public class Cardiodiagnosis {
	private int cardioId;
	private int cardioarrestdetected;
	private Date date;
	private Memberinfo memberinfo;
	private List<Diseasedetail> diseasedetails;
	private List<Symtom> symtoms;
	private List<BloodTest> bloodTests;
	private List<Ecgreport> ecgreports;
	private List<Xray> xrays;
	private List<Wearabledevicedata> wearabledevicedatas;

	public Cardiodiagnosis() {
		// TODO Auto-generated constructor stub
	}

	public Cardiodiagnosis(int cardioId, int cardioarrestdetected, Date date, Memberinfo memberinfo,
			List<Diseasedetail> diseasedetails, List<Symtom> symtoms, List<BloodTest> bloodTests,
			List<Ecgreport> ecgreports, List<Xray> xrays, List<Wearabledevicedata> wearabledevicedatas) {
		super();
		this.cardioId = cardioId;
		this.cardioarrestdetected = cardioarrestdetected;
		this.date = date;
		this.memberinfo = memberinfo;
		this.diseasedetails = diseasedetails;
		this.symtoms = symtoms;
		this.bloodTests = bloodTests;
		this.ecgreports = ecgreports;
		this.xrays = xrays;
		this.wearabledevicedatas = wearabledevicedatas;
	}

	public List<Wearabledevicedata> getWearabledevicedatas() {
		return wearabledevicedatas;
	}

	public void setWearabledevicedatas(List<Wearabledevicedata> wearabledevicedatas) {
		this.wearabledevicedatas = wearabledevicedatas;
	}

	public List<Xray> getXrays() {
		return xrays;
	}

	public void setXrays(List<Xray> xrays) {
		this.xrays = xrays;
	}

	public int getCardioId() {
		return cardioId;
	}

	public void setCardioId(int cardioId) {
		this.cardioId = cardioId;
	}

	public int getCardioarrestdetected() {
		return cardioarrestdetected;
	}

	public void setCardioarrestdetected(int cardioarrestdetected) {
		this.cardioarrestdetected = cardioarrestdetected;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Memberinfo getMemberinfo() {
		return memberinfo;
	}

	public void setMemberinfo(Memberinfo memberinfo) {
		this.memberinfo = memberinfo;
	}

	public List<Diseasedetail> getDiseasedetails() {
		return diseasedetails;
	}

	public void setDiseasedetails(List<Diseasedetail> diseasedetails) {
		this.diseasedetails = diseasedetails;
	}

	public List<Symtom> getSymtoms() {
		return symtoms;
	}

	public void setSymtoms(List<Symtom> symtoms) {
		this.symtoms = symtoms;
	}

	public List<BloodTest> getBloodTests() {
		return bloodTests;
	}

	public void setBloodTests(List<BloodTest> bloodTests) {
		this.bloodTests = bloodTests;
	}

	public List<Ecgreport> getEcgreports() {
		return ecgreports;
	}

	public void setEcgreports(List<Ecgreport> ecgreports) {
		this.ecgreports = ecgreports;
	}

}
