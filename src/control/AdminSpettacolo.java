package control;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.TimeZone;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DBManager;
import model.FilmBean;
import model.FilmDAO;
import model.GenereBean;
import model.SpettacoloBean;
import model.SpettacoloDAO;

@WebServlet("/AdminSpettacolo")
public class AdminSpettacolo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminSpettacolo() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String titolo = request.getParameter("titolo");
		String genere = request.getParameter("genere");
		String regista = request.getParameter("regista");
		String durata = request.getParameter("durata");
		String trailer = request.getParameter("trailer");
		String locandina = request.getParameter("locandina");
		String anno = request.getParameter("anno");
		String slide = request.getParameter("slide");
		String imgslide = request.getParameter("imgslide");
		String sala = request.getParameter("sala");
		String trama = request.getParameter("trama");
		String data = request.getParameter("data");
		String ora = request.getParameter("ora");

		int an = Integer.parseInt(anno);
		int sal = Integer.parseInt(sala);
		int dur = Integer.parseInt(durata);
		boolean sl = Boolean.parseBoolean(slide);
		TimeZone.setDefault(TimeZone.getTimeZone("GMT"));

		String newDate = data + " " + ora;
		Timestamp ts = Timestamp.valueOf(newDate);

		try {
			DBManager man = new DBManager();
			FilmDAO fq = new FilmDAO(man.getConn());
			ArrayList<String> titoli = fq.getTitoli();

			if (titoli.contains(titolo) == false) {

				FilmBean film = new FilmBean();
				film.setTitolo(titolo);
				film.setGenere(genere);
				film.setRegista(regista);
				film.setDurata(dur);
				film.setUrlTrailer(trailer);
				film.setTrama(trama);
				film.setUriLocandina(locandina);
				film.setAnno(an);
				film.setisInSlider(sl);
				film.setFotoSlide(imgslide);
				
				fq.inserisciFilm(film);

				GenereBean gen = new GenereBean();
				gen.setDescrizione(genere);
				gen.setIdGenere(film.getIdGenere());
			}

			SpettacoloDAO sq = new SpettacoloDAO(man.getConn());
			if (sq.controlloSpettacolo(ts, sal) == false) {
				SpettacoloBean spet = new SpettacoloBean();
				spet.setDataOra(ts);
				spet.setIdSala(sal);
				spet.setIdFilm(fq.getIdFilm(titolo));
				sq.inserisciSpettacolo(spet);
				request.setAttribute("esito", "SPETTACOLO INSERITO");
			} else
				request.setAttribute("esito", "SPETTACOLO GIA' ESISTENTE O SALA OCCUPATA");
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/admin-result.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
