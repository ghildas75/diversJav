package ca.godin.dao;

import java.util.*;
import ca.godin.beans.*;
public interface ICategoryDao {
	public Category addCategory(Category c );
	public List<Category> listCategory();
	public Category getCategory(int idCat);
	public void deleteCategory(int idCat);
	public void updateCategory(Category c);
}
