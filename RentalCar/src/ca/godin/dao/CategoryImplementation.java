package ca.godin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import ca.godin.beans.Category;


public class CategoryImplementation  implements ICategoryDao{

	@Override
	public Category addCategory(Category c) {
		// TODO Auto-generated method stub
		Connection cn=DBManager.getConn();
		String sql= "insert into "+Propreite.table_Category+"(Name, DESCRIPTION,NamePicture) ";
		sql+=" values(?,?,?')";
		
		try {
			PreparedStatement	ps = cn.prepareStatement(sql);
			ps.setString(1,c.getNameCategory());
			ps.setString(2,c.getDescription());
			ps.setString(3,c.getNamePicture());
			ps.executeUpdate();
			String sql2="SELECT MAX(IDCAT) AS MAX_ID From "+Propreite.table_Category;
			PreparedStatement ps2=cn.prepareStatement(sql2);
			ResultSet rs=ps2.executeQuery();
			if(rs.next()) {
				c.setIdCategory((rs.getInt("MAX_ID")));
			}
			ps.close();
			ps2.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		
			e.printStackTrace();
		}

		
			return c;
	}

	@Override
	public List<Category> listCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category getCategory(int idCat) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCategory(int idCat) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCategory(Category c) {
		// TODO Auto-generated method stub
		
	}

	
}
