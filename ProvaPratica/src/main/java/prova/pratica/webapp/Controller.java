// Bergamasco Jacopo, 5AIA, A.S. 2024-2025

package prova.pratica.webapp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

	private final int[] MAX_CAPIENZE = {20, 12, 10, 8}; // Posti liberi per location
	
	private int capienze[];
	private List<Prenotazione> prenotazioni;
	
	public Controller() {
        super();
        capienze = MAX_CAPIENZE.clone();
        prenotazioni = new ArrayList<Prenotazione>();
    }

	public void init(ServletConfig config) throws ServletException {
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// JSP		
		String jsp = "Restaurant.jsp";
		
		// Parametri di base		
		request.setAttribute("title", "5AIA - Prova pratica JavaEE");
		request.setAttribute("student", "Jacopo Bergamasco");
		
		// Parametri (i parametri vengono passati solo tramite POST)
		if (request.getMethod().equals("POST")) {
			if (request.getParameter("cancel") != null) {
				// Logica della cancellazione della tabella
				
				prenotazioni.clear();
				capienze = MAX_CAPIENZE.clone();
			} else {
				// Logica di inserimento

				boolean valid = true;
				
				String nome = request.getParameter("name");
				int posto = 0, clienti = 0, tel = 0;
				try { // Controllo valori numerici
					posto = Integer.parseInt(request.getParameter("place"));
					clienti = Integer.parseInt(request.getParameter("clients"));
					tel = Integer.parseInt(request.getParameter("telephone"));
				} catch (NumberFormatException ex) {
					request.setAttribute("error", "Dati inseriti invalidi!");
					valid = false;
				}
				
				// Print di debug
				System.out.println("Nome: " + nome + " | Posto: " + posto + " | Clienti: " + clienti + " | Telefono: " + tel);
				
				// Validazione capienze
				if (clienti > capienze[posto]) {
					request.setAttribute("error", "Capienza massima raggiunta per il posto selezionato!");
				} else if (valid) {
					capienze[posto] -= clienti;
					prenotazioni.add(new Prenotazione(nome, posto, clienti, tel));
					request.setAttribute("success", true);
				}
			}
		}
		
		request.setAttribute("capienze", capienze);
		request.setAttribute("prenotazioni", prenotazioni);
		
		// Dispaccio
		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/" + jsp);
		disp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
