package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DBManager;
import model.SpesaUtenteBean;
import model.SpesaUtenteDAO;

@WebServlet("/AdminClientiTop")
public class AdminClientiTop extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminClientiTop() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<SpesaUtenteBean> utenti = null;

		try {
			DBManager man = new DBManager();
			SpesaUtenteDAO suq = new SpesaUtenteDAO(man.getConn());
			utenti = suq.getClientiTop(5);
		} catch (SQLException ex) {

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("utenti", utenti);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/admin-clienti-top.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
