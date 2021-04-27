
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
import model.PrezzoBean;
import model.PrezzoDAO;

@WebServlet("")
public class Home extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public Home() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	
			throws ServletException, IOException {

		try {
			DBManager man = new DBManager();
			FilmDAO film = new FilmDAO(man.getConn());
			List<FilmBean> listaslide = film.getFilmsSlider();
			request.setAttribute("listaslide", listaslide);
			PrezzoDAO prezzo = new PrezzoDAO(man.getConn());
			List<PrezzoBean> listaprezzi = prezzo.getAllPrezzi();
			request.setAttribute("listaprezzi", listaprezzi);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/index.jsp");
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
