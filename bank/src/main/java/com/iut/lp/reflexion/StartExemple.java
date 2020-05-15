package com.iut.lp.reflexion;

import static com.iut.lp.dao.memoire.MemoireConstants.NUMERO_COMPTE;
import static com.iut.lp.enumerations.ETypeCompte.AVEC_DECOUVERT;
import static com.iut.lp.enumerations.ETypeCompte.SANS_DECOUVERT;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;

import com.iut.lp.enumerations.ETypeCompte;
import com.iut.lp.factory.modele.CompteFactory;
import com.iut.lp.modele.Compte;

public class StartExemple {

	private static final Logger logger = Logger.getLogger(StartExemple.class);

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {

		/*
		 * La réflexion (reflection en anglais) permet l'introspection des classes,
		 * c'est-à-dire de charger une classe, d'en créer une instance et d'accéder aux
		 * membres statiques ou non (appel de méthodes, lire et écrire les attributs)
		 * sans connaître la classe par avance.
		 * 
		 */

		logger.info("-------> Par usage factory -");
		Compte c = CompteFactory.getCompte(SANS_DECOUVERT, NUMERO_COMPTE, 300d);
		logger.info("Solde du compte : " + c.getSolde());
		logger.info(c.toString());

		logger.info("-------> Par réflexion - utilisation généricité Objets - ");
		Object o = createObjectWithReflexion();
		logger.info(o.toString());

		if (o instanceof Compte) {
			Compte c1 = (Compte) o;
			logger.info(c1.getSolde());
		}
	}

	private static Object createObjectWithReflexion() throws ClassNotFoundException, NoSuchMethodException,
			IllegalAccessException, InvocationTargetException, InstantiationException {
		Class<?> cf = Class.forName("com.iut.lp.factory.modele.CompteFactory");
		// Préparation de l'appel de la méthode :
		Method methode = cf.getMethod("getCompte", ETypeCompte.class, String.class, Double.class, Double.class);
		// Invoke -> Appel la méthode -> On reçoit un objet ...
		Object o = methode.invoke(cf.newInstance(), AVEC_DECOUVERT, NUMERO_COMPTE, 500d, 600d);
		return o;
	}
}
