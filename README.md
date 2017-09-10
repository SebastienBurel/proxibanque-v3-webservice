# proxibanque-v3-webservice

## How to use
There are 4 packages( dao, rest, service, metier). Import project into Eclipse and launch it on server. 
If there are errors with Tomcat you should remove Tomcat that was already in Eclipse and put new one. Add this project to Tomcat.
Run Maven build with clean package and run project on server.

## Webservices examples

### Get all clients of one conseiller (GET Method)
To get list of clients of conseiller with id 1 :
http://localhost:8080/projectwebservice/rest/conseiller/getConseillerClients/1

### Get all accounts of one client (GET Method)
To get list of accounts of client with id 1 :
http://localhost:8080/projectwebservice/rest/conseiller/getClientComptes/1

### Delete client (GET Method)
To delete one client with id 1 :
http://localhost:8080/projectwebservice/rest/conseiller/deleteClient/1 

### Create or update client (POST Method)
#### Tool
Install RESTClient pluggin in Firefox : https://addons.mozilla.org/en-US/firefox/addon/restclient/
Choose method POST in RESTClient

Change request header with :
	- Name : Content-Type
	- Value : application/json
  
#### Send request
- To create a client enter url : http://localhost:8080/projectwebservice/rest/conseiller/updateClient in RESTClient plugin
Write in Body json with client's information (attributes) :
{
	"idConseiller": 1,
	"surname": "Example",
	"name": "Sanja",
	"adress": "address",
	"zipCode": "31170",
	"city": "Toulouse",
	"telephone": "24",
	"email": "Sanja"
}

- To update a client enter the same url : http://localhost:8080/projectwebservice/rest/conseiller/updateClient in RESTClient plugin
Write in Body json with client's updated information (attributes) :
{
	"idClient": 1,
	"idConseiller": 1,
	"surname": "Marunica",
	"name": "Sanja",
	"adress": "address",
	"zipCode": "31170",
	"city": "Toulouse",
	"telephone": "24",
	"email": "Sanja"
}
