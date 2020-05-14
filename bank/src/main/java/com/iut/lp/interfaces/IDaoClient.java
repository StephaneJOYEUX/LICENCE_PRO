package com.iut.lp.interfaces;

import java.util.List;

import com.iut.lp.modele.Client;

public interface IDaoClient extends IDao<Client> {

	List<Client> getListClient();
}
