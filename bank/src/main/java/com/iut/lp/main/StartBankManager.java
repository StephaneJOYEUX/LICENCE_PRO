package com.iut.lp.main;

import com.iut.lp.modele.Banque;

public class StartBankManager {

	public static void main(String[] args) {
		try {
			/*
			 * BankManager myBank = new BankManager(MYSQL);
			 * System.out.println(myBank.getCompteByCompteNumberAndClientNumber("client1",
			 * "BD4242424242"));
			 */
			Banque banque = new Banque(1, "ref", "IUTBANK");
			System.out.println(banque.retrait("BD4242424242", "client1", 50d));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
