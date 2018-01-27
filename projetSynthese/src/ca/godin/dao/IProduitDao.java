package ca.godin.dao;
import java.util.*;
import ca.godin.beans.*;

public interface IProduitDao {

public int addProduct(Category c );
public List<Produit> listProducts();
public Produit getProduitById(int idProduit);
public List<Produit> getProduitByKeyWord(String keyWord);
public List<Produit> getProduitSelected();
public void deleteProduct(int IdProduit);
public void updateProduct(Produit p);


}
