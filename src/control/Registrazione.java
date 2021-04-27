package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.*;

@WebServlet("/Registrazione")
public class Registrazione extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("username");
		String password = request.getParameter("password");
		UtenteBean utente = new UtenteBean();
		utente.setEmail(email);
		utente.setPassword(password);
		utente.setIdRuolo(2);

		try {
			DBManager man = new DBManager();
			UtenteDAO utq = new UtenteDAO(man.getConn());
			utq.aggiungiUtente(utente);
			request.getSession().setAttribute("user", utente);

			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/AreaUtente.jsp");
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
