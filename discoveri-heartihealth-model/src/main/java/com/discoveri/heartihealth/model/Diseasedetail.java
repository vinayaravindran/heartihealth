package com.discoveri.heartihealth.model;

import java.util.Date;

public class Diseasedetail {
	private int diseaseId;
	private Date diagnoseddate;
	private Date recovereddate;
	private int isrecovered;
	public Diseasedetail() {
		// TODO Auto-generated constructor stub
	}
	public int getDiseaseId() {
		return diseaseId;
	}
	public void setDiseaseId(int diseaseId) {
		this.diseaseId = diseaseId;
	}
	public Date getDiagnoseddate() {
		return diagnoseddate;
	}
	public void setDiagnoseddate(Date diagnoseddate) {
		this.diagnoseddate = diagnoseddate;
	}
	public Date getRecovereddate() {
		return recovereddate;
	}
	public void setRecovereddate(Date recovereddate) {
		this.recovereddate = recovereddate;
	}
	public int getIsrecovered() {
		return isrecovered;
	}
	public void setIsrecovered(int isrecovered) {
		this.isrecovered = isrecovered;
	}
	

}
