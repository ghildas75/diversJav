package web;
import java.util.*;

import metier.entity.Produit;

public class ProduitModel {
private String motCle;
private List<Produit> produits=new ArrayList<Produit>();
public String getMotCle() {
	return motCle;
}
public void setMotCle(String motCle) {
	this.motCle = motCle;
}
public List<Produit> getProduits() {
	return produits;
}
public void setLstProduits(List<Produit> lstProduits) {
	this.produits= lstProduits;
}

}
