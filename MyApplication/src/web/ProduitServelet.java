package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.fabric.Response;

import dao.IProduitDao;
import dao.ProduitDaoImpl;
import metier.entity.Produit;

import java.util.*;

/**
 * Servlet implementation class ProduitServelet
 */
@WebServlet(name="cs", urlPatterns= {"*.php"})
//@WebServlet("/ProduitServelet")
public class ProduitServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IProduitDao dao;

    /**
     * Default constructor. 
     */
    public ProduitServelet() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	 dao= new ProduitDaoImpl();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String path=request.getServletPath();
		
		if(path.equals("/index.php")) {
			request.getRequestDispatcher("Produit.jsp").forward(request, response);
		}
		else if(path.equals("/findProduct.php")) {
			String mc= request.getParameter("motCle");
			ProduitModel model=new ProduitModel();
		     model.setMotCle(mc);
		     List<Produit> produits=dao.produitparMc("%"+mc+"%");
		     model.setLstProduits(produits);
		     System.out.println(mc);
		     request.setAttribute("mymodel",model);
		     request.getRequestDispatcher("Produit.jsp").forward(request, response);
		     }
		else if (path.equals("/addProduct.php")) {
			  request.setAttribute("product",new Produit());
			 request.getRequestDispatcher("InsertProduit.jsp").forward(request, response);
		}
		else if (path.equals("/SaveProduct.php") && request.getMethod().equals("POST")) {
			System.out.println("hello ");
			Produit prod= new Produit();
			prod.setDesignation(request.getParameter("designation"));
			prod.setPrice(Double.parseDouble(request.getParameter("price")));
			prod.setQuantity(Integer.parseInt(request.getParameter("quantity")));
			System.out.println("hello2 ");
		   Produit produit=dao.save(prod);
		    System.out.println(prod);
		   request.setAttribute("product",produit);
		   request.getRequestDispatcher("confirmation.jsp").forward(request, response);
		}
		
		else if (path.equals("/Supprimer.php")) {
			
			Long id=Long.parseLong(request.getParameter("id"));
			dao.deleteProduit(id);
			 // request.getRequestDispatcher("confirmation.jsp").forward(request, response);
			response.sendRedirect("findProduct.php?motCle=");
		}
    else if (path.equals("/Edit.php")) {
			
			Long id=Long.parseLong(request.getParameter("id"));
		
			 // request.getRequestDispatcher("confirmation.jsp").forward(request, response);
			response.sendRedirect("findProduct.php?motCle=");
		}
		else {
			
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "message goes here");
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
