package com.TxnStat.utils;

public class TxnStatException extends Exception {

	private int errorCode;
	private String errorMessage;

	public TxnStatException(int errCode, String errMsg) {
		this.errorCode = errCode;
		this.errorMessage = "Error :" + errCode + " " + errMsg;

	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
