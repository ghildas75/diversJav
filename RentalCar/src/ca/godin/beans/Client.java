package ca.godin.beans;

import java.util.*;

public class Client {

private int  idClient;
private String  nameClient;
private String adress;
private String email;
private String phoneNumber;
private  ArrayList<Order> lstOrder;

public Client(String nameClient, String adress, String email, String phoneNumber) {
	super();
	this.nameClient = nameClient;
	this.adress = adress;
	this.email = email;
	this.phoneNumber = phoneNumber;
	this.lstOrder=new ArrayList<Order>();
}
public Client() {
	super();
}
public int getIdClient() {
	return idClient;
}
public void setIdClient(int idClient) {
	this.idClient = idClient;
}
public String getNameClient() {
	return nameClient;
}
public void setNameClient(String nameClient) {
	this.nameClient = nameClient;
}
public String getAdress() {
	return adress;
}
public void setAdress(String adress) {
	this.adress = adress;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}
public Collection<Order> getLstOrder() {
	return lstOrder;
}
public void setLstOrder(ArrayList<Order> lstOrder) {
	this.lstOrder = lstOrder;
}


}
