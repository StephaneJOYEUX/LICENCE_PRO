package com.iut.lp.reflexion;

import static com.iut.lp.dao.memoire.MemoireConstants.NUMERO_COMPTE;
import static com.iut.lp.enumerations.ETypeCompte.AVEC_DECOUVERT;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.iut.lp.enumerations.ETypeCompte;

public class ReflexionCompteFactory {

	protected Object createObjectWithReflexion(String className) throws ClassNotFoundException, NoSuchMethodException,
			IllegalAccessException, InvocationTargetException, InstantiationException {
		Class<?> cf = Class.forName(className);
		Method methode = cf.getMethod("getCompte", ETypeCompte.class, String.class, Double.class, Double.class);
		Object o = methode.invoke(cf.newInstance(), AVEC_DECOUVERT, NUMERO_COMPTE, 500d, 600d);
		return o;
	}

}
