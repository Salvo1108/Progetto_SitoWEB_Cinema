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
import model.PrenotazioneDAO;

@WebServlet("/AdminRimuoviPrenotazione")
public class AdminRimuoviPrenotazione extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminRimuoviPrenotazione() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ID = request.getParameter("id");
		int id = Integer.parseInt(ID);
		DBManager man;
		try {
			man = new DBManager();
			PrenotazioneDAO pq = new PrenotazioneDAO(man.getConn());
			pq.rimuoviPrenotazione(id);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("AdminGetPrenotazione");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
