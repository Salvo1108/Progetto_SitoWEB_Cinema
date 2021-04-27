package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DBManager;
import model.RuoloDAO;
import model.UtenteBean;
import model.UtenteDAO;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("username");
		String password = request.getParameter("password");
		request.getSession().setAttribute("email", email);
		request.getSession().setAttribute("password", password);

		try {
			DBManager man = new DBManager();
			RuoloDAO ruolo = new RuoloDAO(man.getConn());
			UtenteDAO ut = new UtenteDAO(man.getConn());
			UtenteBean utente = ut.getUtente(email, password);
			
			request.getSession().setAttribute("user", utente);
			

			int risultato = ruolo.getRuolo(email, password);
			if (risultato == 1) {

				RequestDispatcher dispatcher = request.getRequestDispatcher("AdminHome");
				dispatcher.forward(request, response);
			} else if (risultato == 2) {

				RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/AreaUtente.jsp");
				dispatcher.forward(request, response);
			} else if (risultato == 0) {

				RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/UtenteInesistente.jsp");
				dispatcher.forward(request, response);
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
