package visitors;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private int count;
	private ArrayList<String> visitors;
	
    public index() {
        super();
        count = 0;
        visitors = new ArrayList<String>();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		if (Boolean.parseBoolean(req.getParameter("reset"))) {
			count = 0;
			visitors.clear();
			System.out.println("RESET");
			res.sendRedirect("?");
			return;
		}
		
		count++;
		visitors.add(req.getRemoteAddr() + ":" + req.getRemotePort() + " on " + new Date());
		
		req.setAttribute("count", count);
		req.setAttribute("visitors", visitors);
		
		req.getRequestDispatcher("WEB-INF/index.jsp").forward(req, res);
		System.out.println(visitors.get(count - 1));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
