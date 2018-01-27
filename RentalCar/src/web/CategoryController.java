package web;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import ca.godin.dao.CategoryImplementation;
import ca.godin.dao.ICategoryDao;


/**
 * Servlet implementation class CategoryController
 */
/*@WebServlet("/CategoryController")
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
maxFileSize=1024*1024*10,      // 10MB
maxRequestSize=1024*1024*100)   // 50MB
*/public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  public static final int TAILLE_TAMPON = 10240;
	  public static final String CHEMIN_FICHIERS = "/Users/Portable/fichiers/";
	 private ca.godin.dao.ICategoryDao daoCat;
    /**
     * @see HttpServlet#HttpServlet()
     */
	 
    @Override
  /*  public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	daoCat=new CategoryImplementation();
    }*/

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		

        // On récupère le champ du fichier
        Part part = request.getPart("fichier");
          if(part==null) {
        System.out.println("nulll");
          }
        // On vérifie qu'on a bien reçu un fichier
        String nomFichier = getNomFichier(part);
      System.out.println(nomFichier);

        // Si on a bien un fichier
        if (nomFichier != null && !nomFichier.isEmpty()) {
            String nomChamp = part.getName();
            // Corrige un bug du fonctionnement d'Internet Explorer
            System.out.println(part);
            // On écrit définitivement le fichier sur le disque
            ecrireFichier(part, nomFichier,CHEMIN_FICHIERS );
                      //C:\Users\Portable\Pictures\img\isco.png\
            //C:/Users/Portable/eclipse-workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp2/work/Catalina/localhost/RentalCar/
            //request.setAttribute(nomChamp, nomFichier);
        }

        this.getServletContext().getRequestDispatcher("message.jsp").forward(request, response);
		
	}
	
	
	  private void ecrireFichier( Part part, String nomFichier, String chemin ) throws IOException {
	        BufferedInputStream entree = null;
	        BufferedOutputStream sortie = null;
	        
	        //org.apache.catalina.core.ApplicationPart@fea1cc4
	        //org.apache.catalina.core.ApplicationPart@fea1cc4
	        //C:\Users\Portable\Pictures\img\toni_kroos.jpg
	        //C://fichier
	        try {
	            entree = new BufferedInputStream(part.getInputStream(), TAILLE_TAMPON);
	            sortie = new BufferedOutputStream(new FileOutputStream(new File(chemin + nomFichier)), TAILLE_TAMPON);

	            byte[] tampon = new byte[TAILLE_TAMPON];
	            int longueur;
	            while ((longueur = entree.read(tampon)) > 0) {
	                sortie.write(tampon, 0, longueur);
	            }
	        } finally {
	            try {
	                sortie.close();
	            } catch (IOException ignore) {
	            }
	            try {
	                entree.close();
	            } catch (IOException ignore) {
	            }
	        }
	    }
	
	
	  public static String getNomFichier( Part part ) {
	        for ( String contentDisposition : part.getHeader( "content-disposition" ).split( ";" ) ) {
	            if ( contentDisposition.trim().startsWith( "filename" ) ) {
	                return contentDisposition.substring( contentDisposition.indexOf( '=' ) + 1 ).trim().replace( "\"", "" );
	            }
	        }
	        return "";
	    }   
	
	//recupere le nom de fichier
	/* private String extractFileName(Part part) {
	        String contentDisp = part.getHeader("content-disposition");
	        String[] items = contentDisp.split(";");
	        for (String s : items) {
	            if (s.trim().startsWith("filename")) {
	                return s.substring(s.indexOf("=") + 2, s.length()-1);
	            }
	        }
	        return "";
	    }*/

}
