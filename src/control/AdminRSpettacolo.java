package control;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.TimeZone;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DBManager;
import model.FilmDAO;
import model.FilmSpettacoliDAO;
import model.PrenotazioneDAO;
import model.SpettacoloDAO;

@WebServlet("/AdminRSpettacolo")
public class AdminRSpettacolo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminRSpettacolo() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String titolo = request.getParameter("titolo");
		String data = request.getParameter("data");
		String ora = request.getParameter("ora");

		TimeZone.setDefault(TimeZone.getTimeZone("GMT"));
		String newDate = data + " " + ora;
		Timestamp ts = Timestamp.valueOf(newDate);

		DBManager man;
		try {
			man = new DBManager();
			FilmDAO fq = new FilmDAO(man.getConn());
			int id = fq.getIdFilm(titolo);

			SpettacoloDAO sq = new SpettacoloDAO(man.getConn());
			PrenotazioneDAO pq = new PrenotazioneDAO(man.getConn());
			pq.rimuoviPrenotazione(id, ts);
			sq.rimuoviSpettacolo(id, ts);

			FilmSpettacoliDAO fsq = new FilmSpettacoliDAO(man.getConn());
			if (fsq.getSpettacoliById(id) == false) {
				fq.rimuoviFilm(id);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("esito", "SPETTACOLO RIMOSSO");
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/admin-result.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
