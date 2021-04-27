package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CarrelloSession;


@WebServlet("/RimuoviDalCarrello")
public class RimuoviDalCarrello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public RimuoviDalCarrello() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int i=Integer.parseInt(request.getParameter("index"));
	CarrelloSession car=(CarrelloSession) request.getSession().getAttribute("carrello");
	ArrayList<CarrelloSession.Prenotazione> prenotazioni= car.getPrenotazioni();
	prenotazioni.remove(i);
	RequestDispatcher dispatcher = request.getRequestDispatcher("RiepilogoCarrello");
	dispatcher.forward(request, response);
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
