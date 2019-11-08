package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Client;
import com.example.demo.Repository.ClientRepository;

@Service
public class ClientServ implements IClientServ{
	 
		@Autowired
		private ClientRepository  clientRepository;
		
		@Override
		public List<Client> getAllClients() {
			
			return clientRepository.findAll();
		}

		@Override
		public Client getClientById(long id) {
			return clientRepository.findById(id).orElse(null);
		}

		@Override
		public Client getClientByCode(String code) {
			return clientRepository.getClientByCode(code);
		}

		@Override
		public Client getClientByNP(String nom ,String prenom) {
			return clientRepository.getClientByNP(nom,prenom);
		}

		@Override
		public Client saveClient(Client client) {
			return clientRepository.save(client);
		}

		@Override
		public boolean deleteClient(long id) {
			boolean test = false;
			try {
				System.out.println("am here "+id);
				clientRepository.deleteById(id);
				test=  true;
			} catch (Exception e) {
				test= false;
			}
			return test;
		}

	}
