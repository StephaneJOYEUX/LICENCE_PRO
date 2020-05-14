package com.iut.lp.dao.memoire;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.cfg.NotYetImplementedException;

import com.iut.lp.interfaces.IDaoCompte;
import com.iut.lp.modele.Client;
import com.iut.lp.modele.Compte;

public class MemoireDaoCompte implements IDaoCompte {

	private List<Compte> comptes;

	public MemoireDaoCompte() {
		comptes = new ArrayList<>();
		MemoireDaoClient daoClient = new MemoireDaoClient();
		for (Client client : daoClient.getListClient()) {
			comptes.addAll(client.getComptes());
		}
	}

	@Override
	public boolean create(Compte object) {
		throw new NotYetImplementedException();
	}

	@Override
	public boolean update(Compte object) {
		throw new NotYetImplementedException();
	}

	@Override
	public Compte readById(int id) {
		throw new NotYetImplementedException();
	}

	@Override
	public Compte readByKey(String key) {
		return comptes.get(0);
	}

	@Override
	public boolean delete(Compte object) {
		throw new NotYetImplementedException();
	}

	@Override
	public List<Compte> getComptes() {
		return comptes;
	}

	@Override
	public List<Compte> getComptesByClient(String userId) {
		return comptes;
	}
}
