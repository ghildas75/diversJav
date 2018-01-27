package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Metier.CreditMetier;

/**
 * Servlet implementation class ControllerServelet
 */
@WebServlet(urlPatterns={"/Controller","*.php"})
//@WebServlet("/ControllerServelet")
public class ControllerServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CreditMetier creditMetier;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
  @Override
public void init() throws ServletException {
	// TODO Auto-generated method stub
	  creditMetier= new CreditMetier();
	
}
    public ControllerServelet() {
        super();
        // TODO Auto-generated constructor stub
    }
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("mod", new CreditModel());
		request.getRequestDispatcher("VueCredit.jsp").forward(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	   int duree= Integer.parseInt(request.getParameter("duree"));
		double taux= Double.parseDouble(request.getParameter("taux"));
		double montant= Double.parseDouble(request.getParameter("montant"));
		Double mensulatite=creditMetier.calculMensualite(montant, duree, taux);
		//PrintWriter out=response.getWriter();
		CreditModel cm= new CreditModel();
		cm.setDuree(duree);
		cm.setMontant(montant);
		cm.setTaux(taux);
		cm.setMensulatite(mensulatite);
		request.setAttribute("mod",cm);
	    request.getRequestDispatcher("VueCredit.jsp").forward(request, response);

		
		//doGet(request, response);
	}

}
