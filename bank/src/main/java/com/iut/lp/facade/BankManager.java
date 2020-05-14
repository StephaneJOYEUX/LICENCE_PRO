package com.iut.lp.facade;

import static com.iut.lp.factory.dao.DaoFactory.getDaoFactory;

import java.util.List;

import com.iut.lp.enumerations.EPersistance;
import com.iut.lp.exceptions.BankBusinessException;
import com.iut.lp.exceptions.BankTechnicalException;
import com.iut.lp.factory.dao.DaoFactory;
import com.iut.lp.modele.Client;
import com.iut.lp.modele.Compte;

/**
 * @description : La classe qui fait le lien avec le dao et le modèle. et fait
 *              donc l'interface entre le controlleur et le modèle ...
 * 
 * @author stephane.joyeux
 *
 */
public class BankManager {

	private DaoFactory dao;

	/* Injection de la 'dao' dans le manager : */
	public BankManager(DaoFactory dao) throws BankTechnicalException {
		if (dao == null) {
			throw new BankTechnicalException("* BankManager() * ", "Dao est nulle !");
		}
		this.dao = dao;

	}

	public BankManager(EPersistance typePersistance) throws BankTechnicalException {
		try {
			dao = getDaoFactory(typePersistance);
		} catch (Exception e) {
			throw new BankTechnicalException("* BankManager() * ", e);
		}
	}

	public List<Client> getListClient() throws BankTechnicalException {
		if (dao != null && dao.getDaoClient() != null) {
			return dao.getDaoClient().getListClient();
		}
		throw new BankTechnicalException("* getListClient() *", "- Impossible d'obtenir la 'Dao Client' !");
	}

	public List<Compte> getListCompte() throws BankTechnicalException {
		if (dao != null && dao.getDaoCompte() != null) {
			return dao.getDaoCompte().getComptes();
		}
		throw new BankTechnicalException("* getListClient() *", "- Impossible d'obtenir la 'Dao Compte' !");
	}

	/***
	 * Récupère un objet de type compte en fonction du client et son numéro de
	 * compte :
	 * 
	 * @param numClt : Le numéro du client.
	 * @param numCpt : Le numéro du compte.
	 * @return
	 */
	public Compte getCompteByCompteNumberAndClientNumber(String numClt, String numCpt) throws BankBusinessException {
		List<Client> clients = getListClient();
		for (Client client : clients) {
			if (client.getNumeroClient().equals(numClt)) {
				for (Compte compte : client.getComptes()) {
					if (compte.getNumCompte().equals(numCpt)) {
						// on récupère le compte du client :
						return compte;
					}
				}
			}
		}
		throw new BankBusinessException("* getCompteByCompteNumberAndClientNumber() *",
				"- Compte ou client inexistant !");
	}

	public boolean persisterCompte(Compte compte) {
		// Mettre à jour l'objet compte :
		return dao.getDaoCompte().update(compte);
	}
}
