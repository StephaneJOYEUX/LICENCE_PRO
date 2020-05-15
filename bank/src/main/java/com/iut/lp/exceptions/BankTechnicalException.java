package com.iut.lp.exceptions;

import org.apache.log4j.Logger;

public class BankTechnicalException extends RuntimeException {

	private static final long serialVersionUID = -6712286890191246220L;

	private static final Logger logger = Logger.getLogger(BankTechnicalException.class);

	public BankTechnicalException(String functionName, String message) {
		super(message);
		logger.info("Une erreur 'technique' est survenue dans la fonction : '" + functionName + "'");
		logger.info("L'erreur est : " + message);
	}

	public BankTechnicalException(String functionName, Exception e) {
		super(e);
		logger.info("Une erreur 'technique' est survenue dans la fonction : '" + functionName + "'");
		logger.info("L'erreur est : " + e.getMessage());
	}
}
