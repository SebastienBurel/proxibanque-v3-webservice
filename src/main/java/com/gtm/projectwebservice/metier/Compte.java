package com.gtm.projectwebservice.metier;

public class Compte {

	private long idNumber;
	private long idClient;
	private float balance;

	public long getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(long idNumber) {
		this.idNumber = idNumber;
	}

	public long getIdClient() {
		return idClient;
	}

	public void setIdClient(long l) {
		this.idClient = l;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Compte [idNumber=" + idNumber + ", idClient=" + idClient + ", balance=" + balance + "]";
	}

}
