package com.iut.lp.main;

import static com.iut.lp.enumerations.EPersistance.MYSQL;

import java.util.List;

import org.apache.log4j.Logger;

import com.iut.lp.factory.dao.DaoFactory;
import com.iut.lp.interfaces.IDaoClient;
import com.iut.lp.interfaces.IDaoCompte;
import com.iut.lp.modele.Client;
import com.iut.lp.modele.Compte;

public class StartPoint {

	private static final Logger logger = Logger.getLogger(StartPoint.class);

	public static void main(String[] args) {
		try {
			// Connection à la base MySQL :
			DaoFactory daoF = DaoFactory.getDaoFactory(MYSQL);
			// Connection à la table 'compte' :
			IDaoCompte dao = daoF.getDaoCompte();
			// Connection à la table 'client' :
			IDaoClient daoClient = daoF.getDaoClient(); // 1 -> Appel DAO
			logger.info("===============================");
			logger.info("Voici la liste des comptes : ");
			List<Compte> comptes = dao.getComptes();
			for (Compte compte : comptes) {
				logger.info(compte.toString());
			}
			logger.info("===============================");
			logger.info("Voici la liste des clients : ");
			List<Client> clients = daoClient.getListClient();
			// Je vais réaliser le lien compte - client pour la démonstration :
			for (Client client : clients) {
				logger.info(client.toString());
				// getComptesByClient(dao, client);
			}
		} catch (Exception e) {
			logger.info("Connection impossible " + e.getMessage());
		}

	}

	private static void getComptesByClient(IDaoCompte dao, Client client) {
		// Récupération des comptes du client : --> 1 Appel Dao par client :
		List<Compte> comptesClient = dao.getComptesByClient(client.getNumeroClient());
		for (Compte compte : comptesClient) {
			client.addCompte(compte);
			logger.info(compte.toString());
		}
	}
}
