package com.iut.lp.controller;

import static com.iut.lp.dao.memoire.MemoireConstants.NOM_BANK_TEST;
import static com.iut.lp.dao.memoire.MemoireConstants.NUMERO_BANK_TEST;
import static com.iut.lp.dao.memoire.MemoireConstants.NUMERO_REF_BANK_TEST;

import java.util.List;

import org.apache.log4j.Logger;

import com.iut.lp.exceptions.BankBusinessException;
import com.iut.lp.modele.Banque;
import com.iut.lp.modele.Client;
import com.iut.lp.modele.Compte;
import com.opensymphony.xwork2.ActionSupport;

/***
 * @description : Le 1er controleur de l'application :)
 * 
 * @author stephane.joyeux
 *
 */
public class LoginController extends ActionSupport {

	private static final long serialVersionUID = 5540616014690763867L;

	private Logger logger = Logger.getLogger(LoginController.class);

	private String userCde;

	private String userPwd;

	private String message;

	private List<Compte> comptes;

	public List<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}

	// Le contrôleur est connecté au modèle :
	private Banque banque;

	public LoginController() throws Exception {
		// Il faudrait créer une factory qui renverrai la banque ..
		// --> Beurk :)
		banque = new Banque(NUMERO_BANK_TEST, NUMERO_REF_BANK_TEST, NOM_BANK_TEST);
	}

	public String getUserCde() {
		return userCde;
	}

	public void setUserCde(String userCde) {
		this.userCde = userCde;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String connection() {
		logger.info("Tentative de connection : " + this.getUserCde() + " / " + this.getUserPwd());
		try {
			Client client = banque.getLoginClient(getUserCde(), getUserPwd());
			comptes = banque.getComptesClient(client);
			for (Compte compte : comptes) {
				logger.info(compte.toString());
			}
			logger.info(client.toString());
			setMessage("Le client est reconnu et identification ok");
			return ActionSupport.SUCCESS;
		} catch (BankBusinessException e) {
			setMessage("Probleme sur la connection : " + e.getMessage());
			return "ERROR";
		}
	}
}
