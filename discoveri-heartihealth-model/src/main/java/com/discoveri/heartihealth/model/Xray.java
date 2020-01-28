package com.discoveri.heartihealth.model;

import java.util.Date;
import java.util.List;

public class Xray {
	private int xray_id;
	private Date date;
	private int ca;
	private List<Cardiodiagnosis> cardiodiagnosis;
	
	
	public Xray() {
		// TODO Auto-generated constructor stub
	}
	public int getXray_id() {
		return xray_id;
	}
	public void setXray_id(int xray_id) {
		this.xray_id = xray_id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getCa() {
		return ca;
	}
	public void setCa(int ca) {
		this.ca = ca;
	}
	public List<Cardiodiagnosis> getCardiodiagnosis() {
		return cardiodiagnosis;
	}
	public void setCardiodiagnosis(List<Cardiodiagnosis> cardiodiagnosis) {
		this.cardiodiagnosis = cardiodiagnosis;
	}
	
}
