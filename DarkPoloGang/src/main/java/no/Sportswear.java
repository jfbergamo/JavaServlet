package no;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class Sportswear extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	
	
	DBHelper db;
	
    public Sportswear() {
        super();
        db = new DBHelper();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		Integer userID = (Integer) session.getAttribute("userID");
		List<Account> accounti = null;
		
		String errormessage = "";
		
		boolean logged = false;
		
		try {
			db.connect();
			if ((pwd != null && username != null)) {
				if (db.logon(username, pwd)) {
					session.setAttribute("userID", db.getUserId(username));
					logged = true;
				}
			}
			
			if (userID != null) {
				logged = true;
			}
			
			if (request.getParameter("logout") != null) {
				logged = false;
				session.removeAttribute("userID");
			}
			
			accounti = db.getAccount();
		} catch(SQLException e) {
				errormessage = e.getMessage();
		}
		
		
		request.setAttribute("accounti", accounti);
		request.setAttribute("logged", logged);
		request.setAttribute("errorMessaggio", errormessage);
				
		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/login.jsp");
		disp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
