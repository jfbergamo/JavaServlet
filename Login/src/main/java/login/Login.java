package login;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.Cookie;
import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({"/app", "/app/*"})
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private DbHelper db;
	
    public Login() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		db = new DbHelper();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Session
		HttpSession session = request.getSession();
		response.addCookie(new Cookie("JSESSIONID", session.getId()));
		
		// Login logic
		
		Integer userId = (Integer) session.getAttribute("userId");
		boolean logged;		

		if (request.getMethod().equals("POST")) {
			String email = request.getParameter("email");
			String password = request.getParameter("password");	
			
			try {
				db.connect();
				logged = (userId != null || db.logon(email, password));
				if (logged) session.setAttribute("userId", db.getUserId(email));
			} catch (SQLException ex) {
				setError(500, ex.getMessage(), request, response);
				return;
			}
		} else {
			logged = userId != null;
		}
		
		switch (request.getRequestURI().toLowerCase().replace("/login/app", "")) {
			case "":
			case "/":
			case "/home":
				if (!logged) {
					response.sendRedirect("/Login/app/login");
					return;
				}
				request.getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
				return;
			case "/login":
				if (logged) {
					response.sendRedirect("/Login/app/home");
					return;
				}
				request.setAttribute("failed", !logged && request.getMethod().equals("POST"));
				request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
				return;
			case "/logout":
				session.removeAttribute("userId");
				response.sendRedirect("/Login/app/login");
				return;
			default:
				setError(404, request.getRequestURI().replace("/Login/app", ""), request, response);
				return;
		}
		
	}

	private void setError(int code, String msg, HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setAttribute("code", code);
		req.setAttribute("error", msg);
		req.getRequestDispatcher("/WEB-INF/error.jsp").forward(req, res);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
