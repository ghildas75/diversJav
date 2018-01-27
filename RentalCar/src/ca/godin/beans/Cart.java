package ca.godin.beans;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

public class Cart {

	
	//liste de commande id de produit et details de la commande
	private Map<Integer,OrderDetails> items= new HashMap<Integer, OrderDetails>();
	
public void addItem(Produit p, int quantity) {
	if(items.get(p.getId())==null) {
		OrderDetails or= new OrderDetails();
		or.setProduit(p);
		or.setQuantity(quantity);
		or.setPrice(p.getPrice());
	}
	else {
		OrderDetails or=items.get(p.getId());
		or.setQuantity(or.getQuantity()+quantity);
	}
}

public Collection<OrderDetails> getItems(){
	return items.values();
}
public double getTotal() {

double total=0;
for(OrderDetails or: items.values()) {
	total+=or.getPrice()*or.getQuantity();
}
	return total;
}

public int size() {
	return items.size();
}
public void deleteItem(int idProduit) {
	items.remove(idProduit);
}
}
