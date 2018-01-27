package ca.godin.beans;
import java.util.*;




public class Category {

	private int idCategory;
	private String nameCategory;
	private String  description;
	private byte[] pictures;
	private String namePicture;
	private List<Produit> produits=new ArrayList<>();

	public Category() {
		produits =new ArrayList<>();
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
	public List<Produit> getProduits() {
		return produits;
	}
	

}
