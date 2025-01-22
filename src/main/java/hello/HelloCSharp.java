package hello;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(description = "meglio php", urlPatterns = { "/HelloCSharp" })
public class HelloCSharp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private int visitors;
	
    public HelloCSharp() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		visitors = 0;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		visitors++;
		response.getWriter().println("<h1>Odio C#</h1>");
		response.getWriter().println("Ciao, Java!");
		response.getWriter().println(visitors + " persone hanno visitato questa pagina!");
		response.getWriter().println("<hr>");
		response.getWriter().println("<h4>KESBALLO</h4>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
