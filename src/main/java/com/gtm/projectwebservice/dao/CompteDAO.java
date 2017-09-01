package com.gtm.projectwebservice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gtm.projectwebservice.metier.Compte;

public class CompteDAO extends AbstractDAO {

	/**
	 * Get all accounts of client
	 * 
	 * @param clientId
	 * @return list of accounts
	 * @throws SQLException
	 *             e
	 */
	public List<Compte> getComptesByClientId(long idClient) throws SQLException {
		
		List<Compte> comptes = new ArrayList<Compte>();

		// Get connection to database
		Connection connection = getConnection();

		// Build select query
		String selectSQL = "select idNumber, idClient, balance from compte where idClient = ?";

		// Replace question mark by parameter
		PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
		preparedStatement.setLong(1, idClient);

		// Execute select query
		ResultSet rs = preparedStatement.executeQuery();

		while (rs.next()) {

			Compte compte = new Compte();

			compte.setIdNumber(rs.getLong("idNumber"));
			compte.setIdClient(rs.getLong("idClient"));
			compte.setBalance(rs.getFloat("balance"));

			comptes.add(compte);
		}

		// Close connection to database
		connection.close();

		return comptes;
	}

}
