package ca.godien.bean;

import java.sql.*;
import java.util.*;

public class DBManager {

	
	private static Connection conn=null;
	private static PreparedStatement ps=null;
	private static ResultSet rs=null;
	private static Statement st=null;

	//initialisation de la variable statique en chargement de la mémoire qui sera
	//excute one time
	static {
		//public final static String ConnString=protocole+"//"+ip+":"+port+"/"+nom_base;
		
		try {
			Class.forName(Propreite.pilote);
			conn=DriverManager.getConnection(
					Propreite.protocole+"//"+Propreite.ip+":"+Propreite.port+ 
					"/"+Propreite.nom_base
					,Propreite.user,Propreite.motPasse);
			System.out.println("Data base connected");
		} 

		
		
			
		 catch (Exception e) {
			
			System.out.println(e.getMessage());
		}

		
		
	}


	public static Connection getConn() {
		return conn;
	}

    public  static ArrayList<Employe> DisplayEmploye(){
    	
    	ArrayList<Employe> list= new ArrayList<>();
    	
    	String query="select * from employe";
    	 try {
		 st=conn.createStatement();
		 rs= st.executeQuery(query);
		 while(rs.next()) {
			 
			 Employe em= new Employe();
			 em.setId(rs.getInt(1));
			 em.setName(rs.getString(2));
			 em.setSalary(rs.getDouble(3));
			 em.setDepartment(rs.getString(3));
			 list.add(em);
		 }
		 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
     return list;	
    }

    public  static ArrayList<Employe> getEmployeByDep(String nameDep) {
    	ArrayList<Employe> list= new ArrayList<Employe>();
    	String sql="select * from "+Propreite.table_Employe+ " where department= ?";
    	
    	 try {
    		ps=conn.prepareStatement(sql);
    		ps.setString(1,nameDep);
    		ResultSet rs=ps.executeQuery();
    		while(rs.next()) {
    		Employe em= new Employe();
    		em.setId(rs.getInt(1));
    		em.setName(rs.getString(2));
    		em.setSalary(rs.getDouble(3));
    		em.setDepartment(nameDep);
    		list.add(em);
    	
    			
    		}
    		
    	} catch (SQLException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    		return list;
    	}

    
public  static void addEmploye(Employe em) {
		
		String sql="insert into "+Propreite.table_Employe+" Values(null,?,?,?)";
				
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, em.getName());
			ps.setDouble(2, em.getSalary());
			ps.setString(3, em.getDepartment());
			ps.executeUpdate();
			System.out.println("new employee add in data Base");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
public  static void setAllSalary(double rate) {
	ArrayList<Employe> lst=DisplayEmploye();
	for (Employe employe : lst) {
		double newSalary=employe.getSalary()+(employe.getSalary())*rate;
		employe.setSalary(newSalary);
	}
	
	
}
}

