package passwd;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private final String adminUsr  = "admin@kesballo.org";
	private final String adminPswd = "Pippo1234";
	
    public Login() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		
		boolean logout = request.getParameter("logout") != null;
		boolean logged = (
							(adminUsr.equals(user) && adminPswd.equals(password)) 
							|| (Boolean)session.getAttribute("logged")
						 ) && !logout;

		session.setAttribute("logged", logged);
		
		if (logged) {
			request.getRequestDispatcher("WEB-INF/home.jsp").forward(request, response);
			return;
		}
		
		if (request.getMethod().equals("POST") && !logout) {
			request.setAttribute("failed", !logged);
		}
		
		request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
