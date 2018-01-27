package ca.cgodin.servelet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class MyProduct
 */
@WebServlet("/MyProduct")
public class MyProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String url="jdbc:mysql://localhost:3306/projet?useSSL=false";
	private static Connection con=null;
	private PreparedStatement ps=null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyProduct() {
		super();
		// TODO Auto-generated constructor stub
		
		try {
			Class.forName("com.mysql.jdbc.Driver");

			System.out.println("connection reussi");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    String typeReq=request.getParameter("getReq");
    PrintWriter out= response.getWriter();
    
		if(typeReq.equals("Get all product")) {
		try {
			 con=DriverManager.getConnection(url,"root","");
			String query="select * from produit where description=?";
			 ps = con.prepareStatement(query);
			ps.setString(1,request.getParameter("nameProduct"));
			ResultSet rs= ps.executeQuery();
			response.setContentType("text/html");
			
			out.println("<ul>");
			while(rs.next()) {
				out.println ("<li>"+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+"</li>");
                }
			out.println("</ul>");
			
                    }
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		else if(typeReq.equals("Get one product")) {
		
			
			try {
			 con=DriverManager.getConnection(url,"root","");
			 ps = con.prepareStatement("select * from produit where id=?");
			ps.setInt(1, Integer.parseInt(""+request.getParameter("idProduct")));
			ResultSet rs2= ps.executeQuery();
			if (rs2.next()) {
				out.println ("<p>"+rs2.getInt(1)+" "+rs2.getString(2)+" "+rs2.getString(3)+"</p>");
			}
			else {
				out.println("no product");
			}

		} 
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}


		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
