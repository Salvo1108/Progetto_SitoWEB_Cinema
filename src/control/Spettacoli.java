package control;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DBManager;
import model.FilmBean;
import model.SpettacoloDAO;

@WebServlet("/SpettacoliServlet")
public class Spettacoli extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Spettacoli() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			DBManager man = new DBManager();
			SpettacoloDAO data = new SpettacoloDAO(man.getConn());

			List<Timestamp> date = new ArrayList<>();
			date = data.getDataOra();

			ArrayList<ArrayList<FilmBean>> listafilm = new ArrayList<>();

			for (Timestamp tm : date) {

				ArrayList<FilmBean> temp = data.getFilmByDate(tm);
				listafilm.add(temp);

			}

			request.setAttribute("session", request.getSession());
			request.setAttribute("listafilm", listafilm);
			request.setAttribute("date", date);

			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/spettacoli.jsp");
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
