package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CarrelloSession;
import model.DBManager;
import model.FilmBean;
import model.FilmDAO;
import model.Posto;
import model.PostoDAO;
import model.PrenotazioneDAO;
import model.SalaBean;
import model.SpettacoloDAO;
import model.UtenteBean;

@WebServlet("/AggiungiCarrello")
public class AggiungiCarrello extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AggiungiCarrello() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String id_spet = request.getParameter("id");
			String posti = request.getParameter("posti");

			int spett = Integer.parseInt(id_spet);

			CarrelloSession car = (CarrelloSession) request.getSession().getAttribute("carrello");
			if (car == null) {
				car = new CarrelloSession();
				request.getSession().setAttribute("carrello", car);
			}
			CarrelloSession.Prenotazione pren = new CarrelloSession.Prenotazione();
			DBManager rs;
			

			rs = new DBManager();
			SpettacoloDAO temp = new SpettacoloDAO(rs.getConn());
			PostoDAO po = new PostoDAO(rs.getConn());
			temp.getSpettacoloByID(spett);
			pren.setSpettacolo(temp.getSpettacoloByID(spett));
			FilmDAO fil = new FilmDAO(rs.getConn());
			int idfilm = pren.getSpettacolo().getIdFilm();
			String titolo = fil.getTitleFilmById(idfilm);
			pren.setTitolofilm(titolo);
			pren.setSala(new SalaBean());
			int id_sala = pren.getSpettacolo().getIdSala();
			// creare classe dao per nome sala
			pren.getSala().setIdSala(id_sala);

			ArrayList<CarrelloSession.Posto> listaposti = new ArrayList<>();

			String[] postiArray = posti.split(" ");
			for (int i = 0; i < postiArray.length; i++) {

				String[] tipo = postiArray[i].split(":");
				CarrelloSession.Posto p = new CarrelloSession.Posto();

				p.setIdposto(tipo[0]);
				p.setSala(id_sala);

				switch (tipo[1]) {
				case "Intero":
					p.setPrezzo(9);
					break;
				case "Disabili":
					p.setPrezzo(5);
					break;
				case "Ridotto":
					p.setPrezzo(6);
					break;
				case "Militari":
					p.setPrezzo(5);
					break;
				}
				
				listaposti.add(p);
			}

			pren.setPosti(listaposti);
			car.addPrenotazione(pren);
			
			
			
			
			

			RequestDispatcher dispatcher = request.getRequestDispatcher("SpettacoliUtenteServlet");
			dispatcher.forward(request, response);

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
