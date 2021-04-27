package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DBManager;
import model.UtenteDAO;

@WebServlet("/RecoveryPassword")
public class RecoveryPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RecoveryPassword() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String pw = request.getParameter("password1");
		String pw1 = request.getParameter("password2");

		try {
			DBManager man = new DBManager();
			UtenteDAO ut = new UtenteDAO(man.getConn());

			if (pw.equals(pw1) == false) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/errore-password.jsp");
				dispatcher.forward(request, response);
			}

			if (ut.verificaUtente(email) == false) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UtenteInesistente.jsp");
				dispatcher.forward(request, response);
			}

			if (pw.equals(pw1) && ut.verificaUtente(email)) {
				ut.cambiaPassword(email, pw);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/login.html");
				dispatcher.forward(request, response);
			}

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
