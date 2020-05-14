package com.iut.lp.factory.dao;

import com.iut.lp.dao.mysql.MySqlDaoClient;
import com.iut.lp.dao.mysql.MySqlDaoCompte;
import com.iut.lp.interfaces.IDaoClient;
import com.iut.lp.interfaces.IDaoCompte;

public class MySqlDaoFactory extends DaoFactory {

	@Override
	public IDaoCompte getDaoCompte() {
		// Récupération d'une instance unique de la db vers la table 'compte' :
		// A LIRE ABSOLUMENT le cours '_06c_CoursDAO_20200408.pdf' !
		return MySqlDaoCompte.getMySqlInstance();
	}

	@Override
	public IDaoClient getDaoClient() {
		// Le lien vers la table client :
		return MySqlDaoClient.getMySqlInstance();
	}
}
