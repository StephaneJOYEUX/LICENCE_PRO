package com.iut.lp.dao.mysql;

import static com.iut.lp.dao.mysql.MySqlConnexion.getInstance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.cfg.NotYetImplementedException;

import com.iut.lp.interfaces.IDaoClient;
import com.iut.lp.modele.Client;
import com.iut.lp.modele.CompteSansDecouvert;

public class MySqlDaoClient implements IDaoClient {

	private static final Logger logger = Logger.getLogger(MySqlDaoClient.class);

	// Création d'un singleton pour éviter les instanciations multiples !
	// Ce qu'il y a de plus couteux !
	private static MySqlDaoClient instance;

	// La connection vers la base de données :
	private Connection connection;

	// Création d'une instance de type singleton :
	public static MySqlDaoClient getMySqlInstance() {
		if (instance == null) {
			instance = new MySqlDaoClient();
			logger.info("Connection à la table 'Client' établie !");
		}
		return instance;
	}

	// Constructeur privé --> Donc on peut plus faire de 'new' :
	private MySqlDaoClient() {
		try {
			connection = getInstance();
		} catch (SQLException e) {
			logger.info(e.getMessage());
			logger.info("Connection à la banque est NON ok !");
		}
	}

	@Override
	public boolean create(Client object) {
		throw new NotYetImplementedException();
	}

	@Override
	public boolean update(Client object) {
		throw new NotYetImplementedException();
	}

	@Override
	public Client readById(int id) {
		throw new NotYetImplementedException();
	}

	@Override
	public Client readByKey(String key) {
		throw new NotYetImplementedException();
	}

	@Override
	public boolean delete(Client object) {
		throw new NotYetImplementedException();
	}

	@Override
	public List<Client> getListClient() {
		String mySQL = "SELECT * FROM utilisateur u INNER JOIN compte c ON  u.userId = c.userId";
		List<Client> clients = new ArrayList<>();
		try (PreparedStatement requete = connection.prepareStatement(mySQL)) {
			try (ResultSet res = requete.executeQuery()) {
				// Tant qu'un enregistrement existe :
				while (res.next()) {
					Client client = new Client(res.getString("userId"), res.getString("nom"), res.getString("adresse"));
					// Il faut tester si compte avec ou sans découvert :
					client.addCompte(new CompteSansDecouvert(res.getString("numeroCompte"), res.getDouble("solde")));
					clients.add(client);
				}
			}
		} catch (SQLException e) {
			logger.info("Erreur " + e.getMessage());
		}
		return clients;
	}
}
