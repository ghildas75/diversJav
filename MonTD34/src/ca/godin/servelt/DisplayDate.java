package ca.godin.servelt;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DisplayDate
 */
@WebServlet("/DisplayDate")
public class DisplayDate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int count=0;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DisplayDate() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		count++;

		String nameServer=request.getServerName();
		int numPort=request.getServerPort();
		String conn=request.getHeader("Connection");
		String user=request.getHeader("User-Agent");
		Calendar  calandar=Calendar.getInstance();
		Date myDate= calandar.getTime();
		DateFormat df= new SimpleDateFormat("MM/dd/yyyy");
		String strDate=df.format(myDate);
		df= new SimpleDateFormat("HH:mm:ss");
		String hour=df.format(myDate);
		String bgColor="white";
		if(user.contains("Mozilla")) {
			bgColor="red";
		}
		if(user.contains("Chrome")) {
			bgColor="blue";
		}
		
		
		response.setContentType("text/html");
		try(PrintWriter out=response.getWriter()){
			System.out.println("bg color"+bgColor);
			out.println("<body  style='background-color :"+bgColor+" '+ '>;' ");
			out.println("<ul>");
			out.println("<li>Nom du serveur: "+nameServer+"</li>");
			out.println("<li>Numero de port: "+numPort+"</li>");
			out.println("<li>Type de connection : "+conn+"</li>");
			out.println("<li>la source  de la requete: "+user+"</li></ul><br>");
			out.println("<b>"+"nombre de fois que la servelt es invoque:  <em> "+count+"<em></b><br>");
			out.println("<h1>"+strDate+" "+hour+"</h1>");
			out.println("</body>");
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
