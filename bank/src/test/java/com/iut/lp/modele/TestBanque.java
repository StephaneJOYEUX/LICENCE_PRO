package com.iut.lp.modele;

import static com.iut.lp.dao.memoire.MemoireConstants.NOM_BANK_TEST;
import static com.iut.lp.dao.memoire.MemoireConstants.NUMERO_BANK_TEST;
import static com.iut.lp.dao.memoire.MemoireConstants.NUMERO_REF_BANK_TEST;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TestBanque {

	private Banque banque;

	private static final String NUMERO_COMPTE_TEST = "BD4242424242";
	private static final String NUMERO_CLIENT_TEST = "client1";
	private static final Double SOLDE_COMPTE_TEST = 150d;
	private static final Double RETRAIT = 50d;

	@Before
	public void setUp() throws Exception {
		banque = new Banque(NUMERO_BANK_TEST, NUMERO_REF_BANK_TEST, NOM_BANK_TEST);
	}

	@Test
	public void testRetraitProcess() {
		// 1. Récupération du compte :
		Compte compte = banque.getCompteClient(NUMERO_CLIENT_TEST, NUMERO_COMPTE_TEST);
		assertNotNull(compte);
		// 2. Vérification du solde :
		assertEquals(SOLDE_COMPTE_TEST, compte.getSolde());
		// 3. Opération de retrait :
		assertTrue(banque.retrait(NUMERO_COMPTE_TEST, NUMERO_CLIENT_TEST, RETRAIT));
		// 4. Relecture du compte :
		compte = banque.getCompteClient(NUMERO_CLIENT_TEST, NUMERO_COMPTE_TEST);
		assertNotNull(compte);
		// 5. Vérification du nouveau solde :
		assertEquals(SOLDE_COMPTE_TEST - RETRAIT, compte.getSolde());
	}
}
