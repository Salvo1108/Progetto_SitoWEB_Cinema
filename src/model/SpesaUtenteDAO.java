package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SpesaUtenteDAO {
	private final transient Connection con;

	public SpesaUtenteDAO(DBManager manager) {
		this.con = manager.connection;
	}

	public SpesaUtenteDAO(Connection con) {
		this.con = con;
	}

	/*
	 * @param num numero dei clienti da ritornare return ArrayList contenente i num
	 * clienti migliori (quelli che hanno/hanno fatto più prenotazioni).
	 */
	public ArrayList<SpesaUtenteBean> getClientiTop(int num) throws SQLException {
		ArrayList<SpesaUtenteBean> clienti = new ArrayList<>();
		int i = 0;
		PreparedStatement stm = con
				.prepareStatement("SELECT U.ID_UTENTE, U.EMAIL,U.ID_RUOLO, SUM(P.PREZZO) AS TOT, COUNT(*) AS NUM\n"
						+ "FROM UTENTE U JOIN PRENOTAZIONE PR ON U.ID_UTENTE=PR.ID_UTENTE JOIN PREZZO P ON PR.ID_PREZZO=P.ID_PREZZO\n"
						+ "GROUP BY U.ID_UTENTE ORDER BY SUM(P.PREZZO) DESC");
		try {
			ResultSet rs = stm.executeQuery();
			try {
				SpesaUtenteBean utenti;
				UtenteBean tmp;
				while (rs.next() && i < num) {
					utenti = new SpesaUtenteBean();
					tmp = new UtenteBean();
					tmp.setIdUtente(rs.getInt("ID_UTENTE"));
					tmp.setEmail(rs.getString("EMAIL"));
					tmp.setIdRuolo(rs.getInt("ID_RUOLO"));
					utenti.setUt(tmp);
					utenti.setNumPrenotazioni(rs.getInt("NUM"));
					utenti.setSpesaTot(rs.getDouble("TOT"));
					clienti.add(utenti);
					i++;
				}
			} finally {
				rs.close();
			}
		} finally {
			stm.close();
		}
		return clienti;
	}
}
