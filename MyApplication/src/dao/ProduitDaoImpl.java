package dao;

import java.util.*;
import java.sql.*;

import metier.entity.Produit;

public class ProduitDaoImpl implements IProduitDao {

	
	@Override
	public Produit save(Produit p) {
		Connection cn=DBManager.getConn();
	String sql= "insert into "+Propreite.table_Produit+"( DESIGNATION, PRICE,QUANTITY) ";
	sql+=" values(?,?,?)";
	
	try {
		PreparedStatement	ps = cn.prepareStatement(sql);
		ps.setString(1, p.getDesignation());
		ps.setDouble(2, p.getPrice());
		ps.setInt(3, p.getQuantity());
		ps.executeUpdate();
		String sql2="SELECT MAX(ID) AS MAX_ID From "+Propreite.table_Produit;
		PreparedStatement ps2=cn.prepareStatement(sql2);
		ResultSet rs=ps2.executeQuery();
		if(rs.next()) {
			p.setId(rs.getLong("MAX_ID"));
		}
		ps.close();
		ps2.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
	
		e.printStackTrace();
	}

	
		return p;
	}

	@Override
	public List<Produit> produitparMc(String motCle) {
		Connection cn=DBManager.getConn();
	List<Produit> lst= new ArrayList<>();

	//String mot=motCle.replace("'", "''");
	try {
		
		
		String sql="SELECT * FROM "+Propreite.table_Produit+" where DESIGNATION "+ "like ?";
		PreparedStatement ps = cn.prepareStatement(sql);
		ps.setString(1,motCle);
		ResultSet rs= ps.executeQuery();
		while (rs.next()) {
			Produit p= new Produit();
			p.setId(rs.getLong(1));
			p.setDesignation(rs.getString(2));
			p.setPrice(rs.getDouble(3));
			p.setQuantity(rs.getInt(4));
			lst.add(p);
		}
		ps.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return lst;
	}

	@Override
	public Produit getProduitById(Long id) {
		// TODO Auto-generated method stub
		Connection cn=DBManager.getConn();
		Produit p= new Produit();
		String sql="SELECT * FROM "+Propreite.table_Produit+" WHERE id=? ";
		PreparedStatement ps;
		try {
			ps = cn.prepareStatement(sql);
			ps.setLong(1,id);
			ResultSet rs= ps.executeQuery();
			if(rs.next()) {
				p.setDesignation(rs.getString(2));
				p.setPrice(rs.getDouble(3));
			    p.setQuantity(rs.getInt(4));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return p;
	}

	@Override
	public Produit update(Produit p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteProduit(Long id) {
		
	
		Connection cn=DBManager.getConn();
		String sql= "delete from "+Propreite.table_Produit+" WHERE id=?";
		PreparedStatement ps;
		try {
			ps = cn.prepareStatement(sql);
			ps.setLong(1,id);
			ps.executeUpdate();
			ps.close();
		}
	
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	
	
	}


}
