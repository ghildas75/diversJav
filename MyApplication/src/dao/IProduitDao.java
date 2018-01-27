package dao;
import java.util.*;

import metier.entity.Produit;

public interface IProduitDao {
public Produit save(Produit p);
public List<Produit> produitparMc(String motCle);
public Produit getProduitById(Long id);
public Produit update(Produit p);
public void deleteProduit(Long id);
}
