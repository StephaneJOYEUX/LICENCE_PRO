package com.iut.lp.reflexion;

import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

import java.lang.reflect.InvocationTargetException;

import org.junit.Before;
import org.junit.Test;

public class TestReflexionCompteFactory {

	private ReflexionCompteFactory reflexion;

	@Before
	public void setUp() {
		reflexion = new ReflexionCompteFactory();
	}

	@Test
	public void testCreateCompteWithReflexion() throws ClassNotFoundException, NoSuchMethodException,
			IllegalAccessException, InvocationTargetException, InstantiationException {
		Object o = reflexion.createObjectWithReflexion("com.iut.lp.factory.modele.CompteFactory");
		assertNotNull(o);
		assertEquals("Compte N° FR76 3000 1007941234567890185 à un solde de 500.0 avec un decouvert autorisé !",
				o.toString());
	}

	@Test(expected = NoSuchMethodException.class)
	public void testCreateBanqueWithReflexion() throws ClassNotFoundException, NoSuchMethodException,
			IllegalAccessException, InvocationTargetException, InstantiationException {
		Object o = reflexion.createObjectWithReflexion("com.iut.lp.modele.Banque");
		assertNotNull(o);
	}
}
