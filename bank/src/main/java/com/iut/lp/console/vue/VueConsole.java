package com.iut.lp.console.vue;

import static com.iut.lp.dao.memoire.MemoireConstants.NOM_BANK_TEST;
import static com.iut.lp.dao.memoire.MemoireConstants.NUMERO_BANK_TEST;
import static com.iut.lp.dao.memoire.MemoireConstants.NUMERO_REF_BANK_TEST;

import java.util.List;

import org.apache.log4j.Logger;

import com.iut.lp.modele.Banque;
import com.iut.lp.modele.Client;
import com.iut.lp.modele.Compte;

public class VueConsole {

	private static final Logger logger = Logger.getLogger(VueConsole.class);

	public static void main(String[] args) throws Exception {
		Banque banque = new Banque(NUMERO_BANK_TEST, NUMERO_REF_BANK_TEST, NOM_BANK_TEST);
		Client client = banque.getLoginClient("client1", "clientpass1");
		logger.info(client.toString());
		List<Compte> comptes = banque.getComptesClient(client);
		for (Compte compte : comptes) {
			logger.info(compte.toString());
		}
	}
}
