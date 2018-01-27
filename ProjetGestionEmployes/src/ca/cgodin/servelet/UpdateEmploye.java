package ca.cgodin.servelet;

import java.io.*;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.godien.bean.DBManager;
import ca.godien.bean.Employe;

/**
 * Servlet implementation class UpdateEmploye
 */
@WebServlet("/UpdateEmploye")
public class UpdateEmploye extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static   Connection con=DBManager.getConn();
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEmploye() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String req=request.getParameter("getAdd");
		
		if(req.equals("Add employe")) {
		String name=request.getParameter("inputName");
		double salary= Double.parseDouble(request.getParameter("inputSalary"));
		String nameDept=request.getParameter("inputNameDep");
		Employe em= new Employe(name, salary, nameDept);
		DBManager.addEmploye(em);
		 response.sendRedirect("index.html");
		}
		if(req.equals("Increase salary")) {
			double rate= Double.parseDouble(request.getParameter("inputRate"));
			DBManager.setAllSalary(rate);
			
			}
		 response.sendRedirect("index.html");
		
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
