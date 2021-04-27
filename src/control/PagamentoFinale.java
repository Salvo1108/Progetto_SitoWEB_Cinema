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
import javax.servlet.http.HttpSession;

import model.CarrelloSession;
import model.DBManager;
import model.Posto;
import model.PostoDAO;
import model.PrenotazioneDAO;
import model.PrezzoBean;
import model.PrezzoDAO;
import model.UtenteBean;
import model.UtenteDAO;

/**
 * Servlet implementation class PagamentoFinale
 */
@WebServlet("/PagamentoFinale")
public class PagamentoFinale extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PagamentoFinale() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		// PRENDO DATI DAL CARRELLO
			CarrelloSession carrello = (CarrelloSession) request.getSession().getAttribute("carrello");
			String email = (String) request.getSession().getAttribute("email");
			String password = (String) request.getSession().getAttribute("password");
			PrezzoBean num = new PrezzoBean();
			
			DBManager man;
			
			try {
				man = new DBManager();
				UtenteDAO ut = new UtenteDAO(man.getConn());
				PrezzoDAO pr = new PrezzoDAO(man.getConn());
				PrenotazioneDAO aggiungi = new PrenotazioneDAO(man.getConn());
				PostoDAO po = new PostoDAO(man.getConn());
				UtenteBean utente = ut.getUtente(email, password);
				Posto occupato = new Posto();
				ArrayList<CarrelloSession.Prenotazione> prenotazioni= carrello.getPrenotazioni();
				int sala;
				
				
				
				for(CarrelloSession.Prenotazione p : prenotazioni) {
					for(CarrelloSession.Posto g : p.getPosti()) {
						String riga = g.getIdposto().substring(0,1);
						String colonna = g.getIdposto().substring(1);
						sala = g.getSala(); 
						num = (PrezzoBean)pr.getprezzoBeanByPrezzo(g.getPrezzo());
						
						occupato = po.getPosto(riga, colonna,sala);
						occupato.setStato(true);
						aggiungi.inserisciPrenotazione(utente.getIdUtente(),p.getSpettacolo().getIdSpettacolo(),num.getIdPrezzo(),po.getIDPosto(riga, colonna,sala));
					}
				}
			
			}
			
			catch (ClassNotFoundException | SQLException e1) {
				
				e1.printStackTrace();
			}
				
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/PagamentoConfermato.jsp");
			dispatcher.forward(request, response);
			
			
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
