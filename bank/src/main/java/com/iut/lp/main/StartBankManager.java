package com.iut.lp.main;

import org.apache.log4j.Logger;

import com.iut.lp.modele.Banque;

public class StartBankManager {

	private static final Logger logger = Logger.getLogger(StartBankManager.class);

	public static void main(String[] args) {
		try {
			/*
			 * BankManager myBank = new BankManager(MYSQL);
			 * logger.info(myBank.getCompteByCompteNumberAndClientNumber("client1",
			 * "BD4242424242"));
			 */
			Banque banque = new Banque(1, "ref", "IUTBANK");
			logger.info(banque.retrait("BD4242424242", "client1", 50d));

		} catch (Exception e) {
			logger.info(e.getMessage());
		}

	}

}
