package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CarrelloSession;
import model.DBManager;
import model.FilmDAO;
import model.PrenotazioneUtente;

@WebServlet("/RiepilogoCarrello")
public class RiepilogoCarrello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public RiepilogoCarrello() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CarrelloSession carrello=(CarrelloSession) request.getSession().getAttribute("carrello");
		if(carrello!=null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Carrelloriepilogo.jsp");
			dispatcher.forward(request, response);
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/CarrelloVuoto.jsp");
			dispatcher.forward(request, response);}

}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
