/**
 * 
 */
package com.cfa.ppcse.pojos;

import java.io.Serializable;

/**
 * @author acclimationsupport
 *
 */
public class UpdateRequestBean {//implements Serializable{
	/**
	 * 
	 */
//	private static final long serialVersionUID = 1016335969076970271L;
	private String requestId;
	private String status;
	private int statusCode;

	/**
	 * @return the statusCode
	 */
	public int getStatusCode() {
		return statusCode;
	}

	/**
	 * @param statusCode
	 *            the statusCode to set
	 */
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	/**
	 * @return the requestId
	 */
	public String getRequestId() {
		return requestId;
	}

	/**
	 * @param requestId
	 *            the requestId to set
	 */
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UpdateRequestBean [requestId=" + requestId + ", status=" + status + ", statusCode=" + statusCode + "]";
	}

	
}
