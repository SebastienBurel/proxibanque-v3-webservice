package com.gtm.projectwebservice.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.gtm.projectwebservice.metier.Client;
import com.gtm.projectwebservice.metier.Compte;
import com.gtm.projectwebservice.service.ConseillerService;



@Path("/conseiller")

public class JSONService {
	private ConseillerService conseillerService = new ConseillerService();

@GET
@Path("/getConseillerClients/{idConseiller}")
@Produces(MediaType.APPLICATION_JSON)
public List<Client> getConseillerClients(@PathParam("idConseiller") long idConseiller) {
	return conseillerService.getConseillerClients(idConseiller);
}

@GET
@Path("/getClientComptes/{idClient}")
@Produces(MediaType.APPLICATION_JSON)
public List<Compte> getClientComptes(@PathParam("idClient") long idClient) {
	return conseillerService.getClientComptes(idClient);
}

@POST
@Path("/updateClient")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public Client createClientInJSON(Client newClient) {
	Client createdClient = conseillerService.createClient(newClient);
	String result = "Client : " + createdClient;
	System.out.println(result);
	return createdClient;
}

@GET
@Path("/deleteClient/{idClient}")
@Produces(MediaType.APPLICATION_JSON)
public void deleteClient(@PathParam("idClient") long idClient) {
	conseillerService.deleteClient(idClient);
}
	
/*@Path("/json/client")
public class JSONService {

	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Client getClientInJSON() {
		
		Client client = new Client();
		client.setIdClient(1);
		client.setIdConseiller(2);
		client.setName("Jenny");
		client.setSurname("Wilkinson");
		client.setAdress("23 rue de Belbeze");
		client.setZipCode("21000");
		client.setCity("Split");
		client.setEmail("jenny@hotmail.com");
		client.setTelephone("0625489652");

		return client;
	}
	
	
	*/

}
