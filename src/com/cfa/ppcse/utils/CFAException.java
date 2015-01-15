package com.cfa.ppcse.utils;

import java.util.List;

import org.apache.log4j.Logger;

public class CFAException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1998775329851940685L;
	private static final Logger LOG = Logger.getLogger(CFAException.class);

	/**
	 * Parameterized constructor calls the base Exception class to set up the
	 * values
	 * 
	 * @param errorMessage
	 */
	public CFAException(String errorMessage) {
		super(errorMessage);
	}

	/**
	 * Parameterized constructor calls the base Exception class to set up the
	 * values
	 * 
	 * @param errorCode
	 * @param errorMessage
	 */
	public CFAException(String errorCode, String errorMessage) {
		super(errorCode, errorMessage);
	}

	/**
	 * Parameterized constructor calls the base Exception class to set up the
	 * values
	 * 
	 * @param errorCode
	 * @param errorMessage
	 */
	public CFAException(String errorCode, List<String> errorMessage) {
		super(errorCode, errorMessage);
	}

	/**
	 * Parameterized constructor calls the base exception with the additional
	 * field of Throwable type
	 * 
	 * @param errorCode
	 * @param errorMessage
	 * @param t
	 */
	public CFAException(String errorCode, String errorMessage, Throwable t) {
		super(errorCode, errorMessage, t);
		LOG.fatal(errorMessage, t);
	}
}
