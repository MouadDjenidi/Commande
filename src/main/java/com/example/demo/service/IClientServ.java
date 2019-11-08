package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Client;

public interface IClientServ {
	public List<Client> getAllClients();
	public Client getClientById(long id);
	public Client getClientByCode(String code);
	public Client getClientByNP(String nom,String prenom);
	public Client saveClient(Client client);
	public boolean deleteClient(long id);
}
