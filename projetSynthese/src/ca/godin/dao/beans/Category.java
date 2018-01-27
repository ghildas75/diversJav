package ca.godin.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;



public class Category implements Serializable {

	private int idCategory;
	private String nameCategory;
	private String  description;
	private byte[] pictures;
	private String namePicture;
	private Collection<Produit> produits;

	public Category() {

	}
	public Category(String nameCategory, String description, byte[] pictures, String namePicture) {
		super();
		this.nameCategory = nameCategory;
		this.description = description;
		this.pictures = pictures;
		this.namePicture = namePicture;
		this.produits= new ArrayList<Produit>();
	}
	public int getIdCategory() {
		return idCategory;
	}
	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}
	public String getNameCategory() {
		return nameCategory;
	}
	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public byte[] getPictures() {
		return pictures;
	}
	public void setPictures(byte[] pictures) {
		this.pictures = pictures;
	}
	public String getNamePicture() {
		return namePicture;
	}
	public void setNamePicture(String namePicture) {
		this.namePicture = namePicture;
	}
	public Collection<Produit> getProduits() {
		return produits;
	}
	public void setProduits(Collection<Produit> produits) {
		this.produits = produits;
	}
}
