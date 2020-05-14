package com.iut.lp.dao.memoire;

import static com.iut.lp.dao.memoire.MemoireConstants.NUMERO_CLIENT;
import static com.iut.lp.dao.memoire.MemoireConstants.NUMERO_COMPTE;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.cfg.NotYetImplementedException;

import com.iut.lp.interfaces.IDaoClient;
import com.iut.lp.modele.Client;
import com.iut.lp.modele.Compte;
import com.iut.lp.modele.CompteSansDecouvert;

public class MemoireDaoClient implements IDaoClient {

	private List<Client> clients;
	private List<Compte> comptes;

	private static final String NOM_CLIENT = "nom client test";
	private static final String ADRESSE_CLIENT = "adresse test client";

	public MemoireDaoClient() {
		clients = new ArrayList<>();
		Client client = new Client(NUMERO_CLIENT, NOM_CLIENT, ADRESSE_CLIENT);
		Compte compte = new CompteSansDecouvert(NUMERO_COMPTE, 150d);
		client.addCompte(compte);
		clients.add(client);
		comptes = new ArrayList<>();
		comptes.add(compte);
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
		return clients.get(0);
	}

	@Override
	public Client readByKey(String key) {
		// Return toujours le même client ...
		return clients.get(0);
	}

	@Override
	public boolean delete(Client object) {
		throw new NotYetImplementedException();
	}

	@Override
	public List<Client> getListClient() {
		return clients;
	}
}
