package com.discoveri.heartihealth.exceptions;

public class HeartiExceptions extends Exception {
	private static final long serialVersionUID = 1L;
	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	public HeartiExceptions(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}

	public HeartiExceptions() {
		super();
	}

}
