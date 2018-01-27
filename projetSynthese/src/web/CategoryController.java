package web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.Part;

import ca.godin.dao.CategoryImplementation;
import ca.godin.dao.ICategoryDao;
import ca.godin.beans.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 

 


/**
 * Servlet implementation class Category
 */
@WebServlet("/Category")
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
maxFileSize=1024*1024*10,      // 10MB
maxRequestSize=1024*1024*50)   // 50MB
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String SAVE_DIR = "image";
	private ICategoryDao daoCat;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
  
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		daoCat=new CategoryImplementation();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("Category.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest  request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Category cat= new Category();
		cat.setNameCategory(request.getParameter("namecat"));
		cat.setDescription(request.getParameter("desciption"));
		//String fileName="";
	   // Category caty=daoCat.addCategory(cat);
	   
		String appPath = request.getServletContext().getRealPath("");
        // constructs path of the directory to save uploaded file
        String savePath = appPath + File.separator + SAVE_DIR;
         System.out.println(savePath);
        // creates the save directory if it does not exists
        File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }
         
        for (Part part : request.getParts()) {
            String fileName = extractFileName(part);
            cat.setNamePicture(fileName);
            // refines the fileName in case it is an absolute path
            fileName = new File(fileName).getName();
            part.write(savePath + File.separator + fileName);
        }
        
       
        Category caty=daoCat.addCategory(cat);
        
        request.setAttribute("message", "Upload has been done successfully!");
        request.setAttribute("categorys", caty);
        getServletContext().getRequestDispatcher("/message.jsp").forward(
                request, response);
		 }
	

	private String extractFileName(Part part) {
	    String contentDisp = part.getHeader("content-disposition");
	    String[] items = contentDisp.split(";");
	    for (String s : items) {
	        if (s.trim().startsWith("filename")) {
	            return s.substring(s.indexOf("=") + 2, s.length()-1);
	        }
	    }
	    return "";
	}
	
	
   
}
