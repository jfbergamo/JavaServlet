package passwd;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DbHelper db;
	
    public Login() {
        super();
        db = new DbHelper();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get session and form data
		HttpSession session = request.getSession();
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		
		// Check if user is logged
		boolean logout = request.getParameter("logout") != null;
		boolean logged;
		try {
			db.connect();
			logged = (
						db.logon(user, password)
						|| (session.getAttribute("logged") != null && (Boolean)session.getAttribute("logged"))
					 ) && !logout;
			db.disconnect();
		} catch (SQLException ex) {
			request.setAttribute("error", ex.toString());
			request.getRequestDispatcher("WEB-INF/error.jsp").forward(request, response);
			return;
		}
		
		session.setAttribute("logged", logged);
		
		// Redirects
		
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
