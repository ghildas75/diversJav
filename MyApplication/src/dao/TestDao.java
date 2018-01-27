package dao;

import metier.entity.Produit;
import java.util.*;

public class TestDao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ProduitDaoImpl da= new ProduitDaoImpl();
		Produit p2=da.save(new Produit("Epson l'aser",1000,15));
		/*Produit p1=da.save(new Produit("HP 680",900,45));
		Produit p2=da.save(new Produit("Epson laser",1000,15));
		Produit p2=da.save(new Produit("Epson laser",1000,15));
	System.out.println(p1);
	System.out.println(p2);*/
	List<Produit> prods=da.produitparMc("l'");
	for (Produit produit : prods) {
		
		System.out.println(produit);
	}
	
	
	}

}
