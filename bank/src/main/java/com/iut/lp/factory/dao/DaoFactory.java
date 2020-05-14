package com.iut.lp.factory.dao;

import org.hibernate.cfg.NotYetImplementedException;

import com.iut.lp.enumerations.EPersistance;
import com.iut.lp.interfaces.IDaoClient;
import com.iut.lp.interfaces.IDaoCompte;

/**
 * // A LIRE ABSOLUMENT le cours '_06c_CoursDAO_20200408.pdf' !
 * 
 * @author stephane.joyeux
 *
 */
public abstract class DaoFactory {

	public static DaoFactory getDaoFactory(EPersistance cible) throws Exception {
		DaoFactory daoF = null;
		switch (cible) {
		case MEMOIRE:
			throw new NotYetImplementedException();
		case MYSQL:
			// Création de la session vers la base MySQL :
			return new MySqlDaoFactory();
		default:
			break;
		}
		return daoF;
	}

	// Le lien vers la table 'Compte' :
	public abstract IDaoCompte getDaoCompte();

	// Le lien vers la table 'Client' :
	public abstract IDaoClient getDaoClient();
}
