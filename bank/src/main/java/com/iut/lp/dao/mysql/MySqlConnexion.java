package com.iut.lp.dao.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

/***
 * Classe permettant d'ouvrir 'une session' vers la base de données MySQL.
 * 
 * @author stephane.joyeux
 *
 */
public class MySqlConnexion {

	public static Connection instance = null;

	private static final Logger logger = Logger.getLogger(MySqlConnexion.class);

	// Appel iut ..local host -> infodb.iutmetz.univ-lorraine.fr
	private static final String URL_MYSQL = "jdbc:mysql://localhost:3306/bankiut";
	// C'est mal -> Les données sont lisibles ... !! (fichier properties ...)
	private static final String USER = "root";
	private static final String PASSWORD = "root";

	private MySqlConnexion() {
		// Pour éviter une instanciation directe :
	}

	public static Connection getInstance() throws SQLException {
		if (instance == null) {
			instance = creerConnection();
			logger.info("Connection établie avec le serveur - et la banque !");
		}
		return instance;
	}

	// Créer une 'session' vers la base de données :
	private static Connection creerConnection() throws SQLException {
		return DriverManager.getConnection(URL_MYSQL, USER, PASSWORD);
	}
}
