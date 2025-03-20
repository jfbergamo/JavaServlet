package login;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet({"/app", "/app/*"})
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private DbHelper db;
	
    public Login() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		db = new DbHelper();
		try {
			db.connect();
		} catch (SQLException ex) {}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Session
		HttpSession session = request.getSession();
		
		// Login logic
		
		Integer userId = (Integer) session.getAttribute("userId");
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");	
		
		boolean logged;		
		try {
			logged = (userId != null || db.logon(email, password));
			if (logged) session.setAttribute("userId", db.getUserId(email));
		} catch (SQLException ex) {
			request.setAttribute("error", ex.getMessage());
			request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
			return;
		}
		
// TODO switch per il routing
		
		if (logged) {
			response.sendRedirect("/Login/app/");
			return;
		}
		
		if (logged) {
			request.getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
			return;
		}

		if (logout) session.removeAttribute("userId");
		
		request.setAttribute("failed", !logged && request.getMethod().equals("POST") && !logout);
		request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
