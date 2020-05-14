package com.iut.lp.modele;

import static com.iut.lp.enumerations.EPersistance.MYSQL;

import java.util.Iterator;
import java.util.List;

import org.hibernate.cfg.NotYetImplementedException;

import com.iut.lp.facade.BankManager;

public class Banque {

	/* Le gestionnaire de la banque */
	private BankManager manager;

	private int numero;
	private String reference;
	private String nom;

	// Une banque a une liste de clients.
	private List<Client> clients;
	// Une banque à une liste de comptes.
	private List<Compte> comptes;

	public int getNumero() {
		return numero;
	}

	public String getReference() {
		return reference;
	}

	public String getNom() {
		return nom;
	}

	public Banque(int numero, String reference, String nom, BankManager manager) throws Exception {
		setManager(manager);
		this.numero = numero;
		this.reference = reference;
		this.nom = nom;
		comptes = getManager().getListCompte();
		clients = getManager().getListClient();
	}

	public Banque(int numero, String reference, String nom) throws Exception {
		this(numero, reference, nom, new BankManager(MYSQL));
	}

	public boolean addClient(Client client) {
		return clients.add(client);
	}

	public boolean addCompte(Compte compte) {
		return comptes.add(compte);
	}

	public Compte getCompteClient(String numeroClient, String numeroCompte) {
		for (Client client : clients) {
			if (client.getNumeroClient().equals(numeroClient)) {
				for (Compte compte : client.getComptes()) {
					if (compte.getNumCompte().equals(numeroCompte)) {
						return compte;
					}
				}
			}
		}
		return null;
	}

	/* Méthode de retrait -> courte et simple à comprendre */
	public boolean retrait(String numCompte, String numClient, Double montant) {
		Compte compte = getManager().getCompteByCompteNumberAndClientNumber(numClient, numCompte);
		if (compte != null) {
			if (compte.debiter(montant)) {
				// Persistance en db ! - Ecrire dans la db ..
				//return manager.persisterCompte(compte);
				return persistCompte(compte);
			}
		}
		return false;
	}

	public boolean depot(String numCompte, String numClient, Double montant) {
		Compte compte = getManager().getCompteByCompteNumberAndClientNumber(numClient, numCompte);
		if (compte != null) {
			return compte.crediter(montant);
		}
		return false;
	}

	public boolean ouvertureCompte(String numeroClient) {
		throw new NotYetImplementedException();
	}

	public boolean fermetureCompte(String numeroClient, String numeroCompte) {
		throw new NotYetImplementedException();
	}

	public Double conversionFromEuro(Double montant) {
		throw new NotYetImplementedException();
	}

	public Double conversionToEuro(Double montant) {
		throw new NotYetImplementedException();
	}

	public BankManager getManager() {
		return manager;
	}

	public void setManager(BankManager manager) {
		this.manager = manager;
	}

	/* Simulation de la persistance en db */
	private boolean persistCompte(Compte compteToUpdate) {
		for (Iterator<Client> iterator = clients.iterator(); iterator.hasNext();) {
			Client client = (Client) iterator.next();
			for (Iterator<Compte> iterCompte = client.getComptes().iterator(); iterCompte.hasNext();) {
				Compte compte = (Compte) iterCompte.next();
				if (compte.getNumCompte().equals(compteToUpdate.getNumCompte())) {
					compte.setSolde(compteToUpdate.getSolde());
				}
			}
		}
		return true;
	}
}
