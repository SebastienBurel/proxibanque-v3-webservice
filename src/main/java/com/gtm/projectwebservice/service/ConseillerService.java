package com.gtm.projectwebservice.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gtm.projectwebservice.dao.ClientDAO;
import com.gtm.projectwebservice.dao.CompteDAO;
import com.gtm.projectwebservice.metier.Client;
import com.gtm.projectwebservice.metier.Compte;

public class ConseillerService {

	ClientDAO clientDAO = new ClientDAO();
	CompteDAO compteDAO = new CompteDAO();
	
	/**
	 * Get conseiller list of clients
	 * 
	 * @param conseillerId
	 * @return list of clients
	 */
	
	public List<Client> getConseillerClients(long idConseiller) {
		List<Client> clients = new ArrayList<Client>();

		try {
			clients = clientDAO.getClientByConseillerId(idConseiller);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return clients;
	}
	
	/**
	 * Get client list of accounts
	 * 
	 * @param clientId
	 * @return list of accounts
	 */

	public List<Compte> getClientComptes(long idClient) {
		List<Compte> comptes = new ArrayList<Compte>();
		
		try {
			comptes = compteDAO.getComptesByClientId(idClient);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return comptes;
	}
	
	/**
	 * Create or update client in database
	 * @param client to create
	 * @return updated or create client
	 */
	public Client createClient(Client client) {

		Client createdClient = null;
		try {
			if (null != client) {
				//if client id is superior to 0 then update
				if (client.getIdClient() > 0) {
					createdClient = clientDAO.update(client);
				}
				//else save it
				else {
					createdClient = clientDAO.create(client);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return createdClient;
	}

	public void deleteClient(long idClient) {
		
		try {
			clientDAO.deleteClient(idClient);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
	}

	
}
