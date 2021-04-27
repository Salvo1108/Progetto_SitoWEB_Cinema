package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DBManager;
import model.DettaglioFilmDAO;
import model.FilmBean;
import model.SpettacoloBean;
import model.SpettacoloSalaOrarioDAO;


@WebServlet("/DettaglioFilmUtenti")
public class DettaglioFilmUtenti extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DettaglioFilmUtenti() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ID = request.getParameter("id");
		int id = Integer.parseInt(ID);

		try {
			DBManager man = new DBManager();
			DettaglioFilmDAO film = new DettaglioFilmDAO(man.getConn());
			SpettacoloSalaOrarioDAO orario = new SpettacoloSalaOrarioDAO(man.getConn());

			FilmBean film2 = film.getFilmConID(id);
			List<SpettacoloBean> orario2 = orario.getSpettacolo(id);

			request.setAttribute("dettagliofilm", film2);
			request.setAttribute("dettagliorario", orario2);

			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/dettaglio-film-utente.jsp");

			dispatcher.forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
