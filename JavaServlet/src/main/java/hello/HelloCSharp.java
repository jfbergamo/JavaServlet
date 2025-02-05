package hello;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
		String linguaggio = request.getParameter("lang");
		boolean reset = Boolean.parseBoolean(request.getParameter("reset"));
		if (linguaggio == null) linguaggio = "C#";
		
		if (reset) {
			visitors = 0;
			response.sendRedirect("?reset=false");
			return;
		}
		visitors++;
		
//		response.getWriter().println("<h1>Odio " + linguaggio + "</h1>");
//		response.getWriter().println("Ciao, da Java!");
//		response.getWriter().println(visitors + " persone hanno visitato questa pagina!");
//		response.getWriter().println("<hr>");
//		response.getWriter().println("<a href=\"?reset=true\"><button>Reset</button></a>");
//		response.getWriter().println("<h4>KESBALLO</h4>");
		
		request.setAttribute("visitors", visitors);
		request.setAttribute("linguaggio", linguaggio);
		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/VisitorViewer.jsp");
		disp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
