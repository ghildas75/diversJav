package ca.cgodin.servelet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.godien.bean.DBManager;
import ca.godien.bean.Employe;

import java.sql.*;
import java.util.*;
/**
 * Servlet implementation class GetEmployee
 */
@WebServlet("/GetEmployee")
public class GetEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static   Connection con=DBManager.getConn();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		ArrayList<Employe> lst=DBManager.DisplayEmploye();
	    response.setContentType("text/html");
	    String req1=request.getParameter("getReq");
	    if(req1==null) req1="";
		try(PrintWriter out=response.getWriter())
		{
			if(request.getParameter("getReq").equalsIgnoreCase("display all employe")) {
				out.println("<ul>");
				for (Employe employe : lst) {
				out.println("<li>"+employe+"</li>");
			}
				out.println("</ul>");
				response.setContentType("text/html");
				RequestDispatcher rd = request.getRequestDispatcher("index.html");
				rd.include(request, response);
				
			}
			
			if(request.getParameter("getReq").equalsIgnoreCase("displaybyDepartment")) {
				System.out.println("YES SECOND REQ");
				
				String nameDept= request.getParameter("inputDept");
				ArrayList<Employe> list=DBManager.getEmployeByDep(nameDept);
				
				out.println("<ul>");
				for (Employe employe : list) {
				out.println("<li>"+employe+"</li>");
				System.out.println("list de employe par departement"+employe);
			}
				out.println("</ul>");
				response.setContentType("text/html");
				RequestDispatcher rd = request.getRequestDispatcher("index.html");
				rd.include(request, response);
				
			}
			
			
		}
		
		
		/*for (Employe employe : lst) {
		System.out.println(employe);
	}*/
		
	 
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	
	
	
	}

}
