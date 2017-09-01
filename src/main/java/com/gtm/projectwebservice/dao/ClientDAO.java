package com.gtm.projectwebservice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gtm.projectwebservice.metier.Client;

public class ClientDAO extends AbstractDAO {

	/**
	 * Get all clients of conseiller
	 * @param idConseiller conseiller id 
	 * @return list of clients
	 * @throws SQLException e
	 */

	public List<Client>getClientByConseillerId(long idConseiller) throws SQLException {
		
		List<Client> clients = new ArrayList<Client>();
		
		// Get connection to database
				Connection connection = getConnection();
				
		String selectSQL = "select idClient, idConseiller, surname, name, adress, zipCode, city, telephone, email from client where idConseiller = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
		preparedStatement.setLong(1, idConseiller);
		ResultSet rs = preparedStatement.executeQuery();
		while (rs.next()) {
					
			Client client = new Client();
			
			client.setIdClient(rs.getLong("idClient"));
			client.setIdConseiller(rs.getLong("idConseiller"));
			client.setSurname(rs.getString("surname"));
			client.setName(rs.getString("name"));
			client.setAdress(rs.getString("adress"));
			client.setZipCode(rs.getString("zipCode"));
			client.setCity(rs.getString("city"));
			client.setTelephone(rs.getString("telephone"));
			client.setEmail(rs.getString("email"));
			
			clients.add(client);
			
		}
		
		connection.close();
		
		return clients;
	}
	
	
	/**
	 * Get client by his id
	 * @param clientId client id 
	 * @return list of clients
	 * @throws SQLException e
	 */
	public Client getClientById(long clientId) throws SQLException {
		Client client = null;
		
		// Get connection to database
		Connection connection = getConnection();
		
		String selectSQL = "select idClient, idConseiller, surname, name, adress, zipCode, city, telephone, email from client where idClient = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
		preparedStatement.setLong(1, clientId);
		ResultSet rs = preparedStatement.executeQuery();
		if (rs.next()) {
			
			client = new Client();
			
			client.setIdClient(rs.getLong("idClient"));
			client.setIdConseiller(rs.getLong("idConseiller"));
			client.setSurname(rs.getString("surname"));
			client.setName(rs.getString("name"));
			client.setAdress(rs.getString("adress"));
			client.setZipCode(rs.getString("zipCode"));
			client.setCity(rs.getString("city"));
			client.setTelephone(rs.getString("telephone"));
			client.setEmail(rs.getString("email"));
			
		}
		
		// Close connection to database
		connection.close();
		
		return client;
	}
	
	/**
	 * get maximum value of id client in database
	 * @return max value of idClient
	 * @throws SQLException e
	 */
	private long getMaxIdCLient() throws SQLException {
		
		long maxId = 0;
		
		//Again get connection to database
		Connection connection = getConnection();
		
		String selectSQL = "select max(idClient) from client";
		PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
		ResultSet rs = preparedStatement.executeQuery();
		if (rs.next()) {
			maxId = rs.getInt(1);
		
		}
		
		//close connection
		
		connection.close();
		
		return maxId;
	}

	
	/**
	 * Create client in database
	 * @param client to create
	 * @return created client
	 * @throws SQLException
	 */
	public Client create(Client client) throws SQLException {
		Client createdClient = null;

		// Get connection to database
		Connection connection = getConnection();
		
		long newClientId = getMaxIdCLient()+1;
		
		String selectSQL = "insert into client (idClient,idConseiller,surname,name,adress,zipCode,city,telephone,email) values (?,?,?,?,?,?,?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
		preparedStatement.setLong(1, newClientId);
		preparedStatement.setLong(2, client.getIdConseiller());
		preparedStatement.setString(3, client.getSurname());
		preparedStatement.setString(4, client.getName());
		preparedStatement.setString(5, client.getAdress());
		preparedStatement.setString(6, client.getZipCode());
		preparedStatement.setString(7, client.getCity());
		preparedStatement.setString(8, client.getTelephone());
		preparedStatement.setString(9, client.getEmail());
		
		// Insert client in database
		preparedStatement.executeUpdate();
		
		// Close connection to database
		connection.close();
		
        createdClient = getClientById(newClientId);
        
		return createdClient;
	}
	
	

	/**
	 * Update client in database
	 * @param clientto update
	 * @return updated client
	 * @throws SQLException e
	 */
	public Client update(Client client) throws SQLException {
		
		Client updatedClient = null;

		// Get connection to database
		Connection connection = getConnection();
		
		// Build update query
		String selectSQL = "update client set idConseiller=? , surname=? , name=? , adress=? , zipCode=? , city=? , telephone=? , email=? where idClient = ?";
		
		// Replace question marks by parameters
		PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
		preparedStatement.setLong(1, client.getIdConseiller());
		preparedStatement.setString(2, client.getSurname());
		preparedStatement.setString(3, client.getName());
		preparedStatement.setString(4, client.getAdress());
		preparedStatement.setString(5, client.getZipCode());
		preparedStatement.setString(6, client.getCity());
		preparedStatement.setString(7, client.getTelephone());
		preparedStatement.setString(8, client.getEmail());
		preparedStatement.setLong(9, client.getIdClient());
		
		// Execute update query
		preparedStatement.executeUpdate();
		
		// Get update client from database
		updatedClient = getClientById(client.getIdClient());
		
		// Close connection to database
		connection.close();
		
		return updatedClient;
	}
	
	/**
	 * Delete client from database
	 * @param client to delete
	 * @return deleted client
	 * @throws SQLException e
	 */
	public void deleteClient(long idClient) throws SQLException {

		// Get connection to database
		Connection connection = getConnection();
		
		String selectSQL = "delete from client where idClient = ?";
		
		// Replace question marks by parameters
		PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
		preparedStatement.setLong(1, idClient);
		
	
		preparedStatement.executeUpdate();

		connection.close();
		
		
	}
	
	
}
