package es3;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class indovina
 */
@WebServlet("/indovina")
public class indovina extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private int num;
	private Random rng;
	
    public indovina() {
        super();
        rng = new Random(System.currentTimeMillis());
        num = rng.nextInt(1, 1000);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String info;
		try {
			int user = Integer.parseInt(request.getParameter("num"));
			if (user > num) {
				info = "Alto!";
			} else if (user < num) {
				info = "Basso!";
			} else {
				info = "Hai vinto!";
				num = rng.nextInt(1, 1000);
			}
		} catch (NumberFormatException ex) {
			info = "Benvenuto!";
		}
		request.setAttribute("info", info);
		request.getRequestDispatcher("WEB-INF/indovina.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
