package prova.pratica.webapp;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/App")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L; 

	public Controller() {
        super();
        
    }

	public void init(ServletConfig config) throws ServletException {
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Define JSP to use		
		String jsp = "Template.jsp";
		
		// Pass some data to JSP		
		request.setAttribute("title", "5AIA - Prova pratica JavaEE");
		request.setAttribute("student", "Jacopo Bergamasco");
		request.setAttribute("error", "Fatal Error!");
		
		// Dispatch to JSP
		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/"+jsp);
		disp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
