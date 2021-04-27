package control;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CarrelloSession;
import model.DBManager;
import model.Posto;
import model.PostoDAO;
import model.SpettacoloSalaOrario;
import model.SpettacoloSalaOrarioDAO;

@WebServlet("/PrenotazioneServlet")
public class Prenotazione extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Prenotazione() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String ID = request.getParameter("id");
		int id = Integer.parseInt(ID);
		String d = request.getParameter("data");
		Timestamp data = Timestamp.valueOf(d);

		SpettacoloSalaOrario spetsala = null;
		ArrayList<Posto> listaposti = new ArrayList<Posto>();
		

		try {
			DBManager man = new DBManager();
			SpettacoloSalaOrarioDAO sp = new SpettacoloSalaOrarioDAO(man.getConn());
			spetsala = sp.getSpettacolo1(id, data);
			PostoDAO ps = new PostoDAO(man.getConn());
			listaposti = ps.getPostiLiberi(spetsala.getSpettacolo());
			ArrayList<Posto> temp = new ArrayList<Posto>();
			temp = ps.getPostiPrenotati(spetsala.getSpettacolo());
			
			for (int i = 0; i < temp.size(); i++) {
				
				listaposti.add(temp.get(i));
			}
			
			if(request.getSession().getAttribute("carrello")!=null){
				CarrelloSession car = (CarrelloSession)request.getSession().getAttribute("carrello");
				ArrayList<CarrelloSession.Prenotazione> listaprenotazioni = car.getPrenotazioni();
				
				for(CarrelloSession.Prenotazione pren: listaprenotazioni) {
					
					if(pren.getSpettacolo().getIdSala()==spetsala.getSala().getIdSala()) {
						
						for(CarrelloSession.Posto posti : pren.getPosti()) {
						
							String riga = posti.getIdposto().substring(0,1);
							String colonna = posti.getIdposto().substring(1);
							Posto temporaneo = ps.getPosto(riga, colonna, spetsala.getSala().getIdSala());
							int id_1 = temporaneo.getP().getIdPosto();
							
							ArrayList<Posto> toRemove = new ArrayList<>();
							for (Posto p : listaposti) {
							    if (p.getP().getIdPosto()==id_1) {
							        toRemove.add(p);
							    }
							}
							listaposti.removeAll(toRemove);
							
							temporaneo.setStato(true);
							listaposti.add(temporaneo);
							}
							}
							
							}
					
						}
						
			Comparator<Posto> ordina = new Comparator<Posto>() {
				public int compare(Posto o1, Posto o2) {
					if (o1.getP().getRiga() < (o2.getP().getRiga()))
						return -1;
					else if (o1.getP().getRiga() > (o2.getP().getRiga()))
						return 1;
					return 0;
				}
			};

			Collections.sort(listaposti, ordina);
			}
			
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("listaposti", listaposti);
		request.setAttribute("spetsalaora", spetsala);
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/prenotazione.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
