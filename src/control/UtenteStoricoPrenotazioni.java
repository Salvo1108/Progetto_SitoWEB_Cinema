package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TimeZone;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AdminPrenotazioneUtentiBean;
import model.DBManager;
import model.StoricoPrenotazioneAreaUtenteDAO;
import model.UtenteBean;

@WebServlet("/UtenteStoricoPrenotazioni")
public class UtenteStoricoPrenotazioni extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UtenteStoricoPrenotazioni() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<AdminPrenotazioneUtentiBean> lista = null;
		TimeZone.setDefault(TimeZone.getTimeZone("GMT"));
		HttpSession currentSession = request.getSession();
		UtenteBean ut = new UtenteBean();
		ut = (UtenteBean) currentSession.getAttribute("user");
		int id = ut.getIdUtente();

		DBManager man;
		try {
			man = new DBManager();
			StoricoPrenotazioneAreaUtenteDAO stor = new StoricoPrenotazioneAreaUtenteDAO(man);
			lista = (ArrayList<AdminPrenotazioneUtentiBean>) stor.getPrenotazioni(id);

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("prenotazione", lista);
		request.getRequestDispatcher("WEB-INF/jsp/storicoprenotazione.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
