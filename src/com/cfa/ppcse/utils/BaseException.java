/**
 * 
 */
package com.cfa.ppcse.utils;

import java.util.List;

/**
 * @author anandap
 * 
 */
public class BaseException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5428347102971143528L;
	private String errorCode;
	private String erroMessage;
	private List<String> msgList;

	public BaseException(String errorMessage) {
		this.erroMessage = errorMessage;
	}

	public BaseException(String errorCode, String errorMessage) {
		this.erroMessage = errorMessage;
		this.errorCode = errorCode;
	}

	public BaseException(String errorCode, List<String> msgList) {
		this.msgList = msgList;
		this.errorCode = errorCode;
	}

	public BaseException(String errorCode, String errorMessage, Throwable t) {

	}

	/**
	 * @return the msgList
	 */
	public List<String> getMsgList() {
		return msgList;
	}

	/**
	 * @param msgList
	 *            the msgList to set
	 */
	public void setMsgList(List<String> msgList) {
		this.msgList = msgList;
	}

	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode
	 *            the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @return the erroMessage
	 */
	public String getErroMessage() {
		return erroMessage;
	}

	/**
	 * @param erroMessage
	 *            the erroMessage to set
	 */
	public void setErroMessage(String erroMessage) {
		this.erroMessage = erroMessage;
	}

}
