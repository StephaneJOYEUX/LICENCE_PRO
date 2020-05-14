package com.iut.lp.dto;

import static com.iut.lp.dao.BankConstants.DECOUVERT_AUTORISE;
import static com.iut.lp.dao.BankConstants.MONTANT_DECOUVERT_AUTORISE;
import static com.iut.lp.dao.BankConstants.NUMERO_COMPTE;
import static com.iut.lp.dao.BankConstants.SOLDE;
import static com.iut.lp.enumerations.ETypeCompte.getType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iut.lp.enumerations.ETypeCompte;
import com.iut.lp.factory.modele.CompteFactory;
import com.iut.lp.modele.Compte;

public class CompteDto {

	/*
	 * Design Pattern 'Adapter' qui transforme un resultSet en un compte -> liste
	 * comptes.
	 */
	public List<Compte> adapt(PreparedStatement requete) throws SQLException {
		List<Compte> comptes = new ArrayList<>();
		ResultSet res = requete.executeQuery();
		while (res.next()) {
			String numCompte = res.getString(NUMERO_COMPTE);
			Double solde = res.getDouble(SOLDE);
			Double decouvertAutorise = res.getDouble(MONTANT_DECOUVERT_AUTORISE);
			String autorisationDecouvert = res.getString(DECOUVERT_AUTORISE);
			ETypeCompte typeCompte = getType(autorisationDecouvert);
			comptes.add(CompteFactory.getCompte(typeCompte, numCompte, solde, decouvertAutorise));
		}
		return comptes;
	}
}
