package com.iut.lp.controller;

import org.apache.log4j.Logger;

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
		logger.info("Je suis connecté");
		setMessage("ça fonctionne");
		return ActionSupport.SUCCESS;
	}
}
