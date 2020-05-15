package com.iut.lp.exceptions;

import org.apache.log4j.Logger;

public class BankBusinessException extends RuntimeException {

	private static final Logger logger = Logger.getLogger(BankBusinessException.class);

	private static final long serialVersionUID = 4594698913800005924L;

	public BankBusinessException(String functionName, String message) {
		super(message);
		logger.info("Une erreur 'métier' est survenue dans la fonction : '" + functionName + "'");
		logger.info("L'erreur est : " + message);
	}

	public BankBusinessException(String functionName, Exception e) {
		super(e);
		logger.info("Une erreur 'métier' est survenue dans la fonction : '" + functionName + "'");
		logger.info("L'erreur est : " + e.getMessage());
	}
}
