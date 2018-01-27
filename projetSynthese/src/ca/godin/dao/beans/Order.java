package ca.godin.beans;

import java.util.Collection;
import java.util.Date;

public class Order {

	private int idOrder;
	private Date  DateOrder;
	private Collection<OrderDetails> items;
	private Client client;
	
	public Order() {
		super();
	}
	public int getIdOrder() {
		return idOrder;
	}
	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}
	public Date getDateOrder() {
		return DateOrder;
	}
	public void setDateOrder(Date dateOrder) {
		DateOrder = dateOrder;
	}
	public Collection<OrderDetails> getItems() {
		return items;
	}
	public void setItems(Collection<OrderDetails> items) {
		this.items = items;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
}
