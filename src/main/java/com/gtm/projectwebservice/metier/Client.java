package com.gtm.projectwebservice.metier;

public class Client {
	
	private long idClient;
	private long idConseiller;
	private String name;
	private String surname;
	private String adress;
	private String zipCode;
	private String city;
	private String telephone;
	private String email;
	
	
	public long getIdClient() {
		return idClient;
	}
	public void setIdClient(long idClient) {
		this.idClient = idClient;
	}
	public long getIdConseiller() {
		return idConseiller;
	}
	public void setIdConseiller(long idConseiller) {
		this.idConseiller = idConseiller;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", idConseiller=" + idConseiller + ", name=" + name + ", surname="
				+ surname + ", adress=" + adress + ", zipCode=" + zipCode + ", city=" + city + ", telephone="
				+ telephone + ", email=" + email + "]";
	}
	
}
