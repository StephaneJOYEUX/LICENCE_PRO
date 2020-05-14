package com.iut.lp.modele;

import static com.iut.lp.dao.memoire.MemoireConstants.NOM_BANK_TEST;
import static com.iut.lp.dao.memoire.MemoireConstants.NUMERO_BANK_TEST;
import static com.iut.lp.dao.memoire.MemoireConstants.NUMERO_CLIENT;
import static com.iut.lp.dao.memoire.MemoireConstants.NUMERO_COMPTE;
import static com.iut.lp.dao.memoire.MemoireConstants.NUMERO_REF_BANK_TEST;
import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import com.iut.lp.dao.memoire.MemoireDaoClient;
import com.iut.lp.dao.memoire.MemoireDaoCompte;
import com.iut.lp.facade.BankManager;
import com.iut.lp.factory.dao.DaoFactory;

public class TestBanqueAvecMockito {

	private Banque banque;

	private static final double MONTANT_RETRAIT = 5d;

	@Before
	public void setUp() throws Exception {
		DaoFactory dao = mock(DaoFactory.class);
		when(dao.getDaoClient()).thenReturn(new MemoireDaoClient());
		when(dao.getDaoCompte()).thenReturn(new MemoireDaoCompte());
		banque = new Banque(NUMERO_BANK_TEST, NUMERO_REF_BANK_TEST, NOM_BANK_TEST, new BankManager(dao));
	}

	@Test
	public void testRetraitProcess() {
		Compte compte = banque.getCompteClient(NUMERO_CLIENT, NUMERO_COMPTE);
		assertNotNull(compte);
		double soldeAvantRetrait = compte.getSolde();
		assertTrue(banque.retrait(NUMERO_COMPTE, NUMERO_CLIENT, MONTANT_RETRAIT));
		assertEquals(soldeAvantRetrait - MONTANT_RETRAIT, compte.getSolde());
	}
}
