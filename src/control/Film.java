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
import model.FilmBean;
import model.FilmDAO;


@WebServlet("/Film")
public class Film extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public Film() {
		super();
		// TODO Auto-generated constructor stub
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			DBManager man = new DBManager();
			FilmDAO film = new FilmDAO(man.getConn());
			List<FilmBean> listafilm = film.getFilms();

			request.setAttribute("listafilm", listafilm);

			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/film.jsp");
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
