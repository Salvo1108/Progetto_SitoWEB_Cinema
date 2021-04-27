package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TimeZone;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AdminPrenotazioneUtentiBean;
import model.DBManager;
import model.SpettacoloSalaOrarioDAO;

@WebServlet("/AdminGetPrenotazione")
public class AdminGetPrenotazione extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminGetPrenotazione() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<AdminPrenotazioneUtentiBean> result = null;
		TimeZone.setDefault(TimeZone.getTimeZone("GMT"));

		DBManager man;
		try {
			man = new DBManager();
			SpettacoloSalaOrarioDAO spet = new SpettacoloSalaOrarioDAO(man.getConn());
			result = spet.getPrenotazioni();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		request.setAttribute("info", result);
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/WEB-INF/jsp/admin-getprenotazioni.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
