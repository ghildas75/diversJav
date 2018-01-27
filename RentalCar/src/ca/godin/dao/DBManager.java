package ca.godin.dao;

import java.sql.*;
import java.util.*;

public class DBManager {

	private static Connection conn=null;
	

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

    

   
    

	
}


