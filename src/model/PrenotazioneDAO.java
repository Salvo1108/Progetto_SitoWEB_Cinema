package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Timestamp;

public class PrenotazioneDAO {
	private final transient Connection con;

	public PrenotazioneDAO(DBManager manager) {
		this.con = manager.connection;
	}

	public PrenotazioneDAO(Connection con) {
		this.con = con;
	}



	/*
	 * cancella una prenotazione di un utente dal database. pr prenotazione da
	 * eliminare ut utente a cui rimborsare il costo della prenotazione
	 */
	public void rimuoviPrenotazione(int id, Timestamp data) throws SQLException {
		PreparedStatement stm1 = con
				.prepareStatement("SELECT ID_SPETTACOLO FROM SPETTACOLO WHERE ID_FILM=? AND DATA_ORA=? ");
		stm1.setInt(1, id);
		stm1.setTimestamp(2, data);
		ResultSet rs = stm1.executeQuery();
		int idspet = 0;
		if (rs.next())
			idspet = rs.getInt("ID_SPETTACOLO");
		PreparedStatement stm = con.prepareStatement("DELETE FROM PRENOTAZIONE WHERE ID_SPETTACOLO=?");
		try {
			stm.setInt(1, idspet);
			stm.executeUpdate();

		} finally {
			stm.close();
		}
	}

	/* rimuovi prenotazione da id */
	public void rimuoviPrenotazione(int id) throws SQLException {
		PreparedStatement stm = con.prepareStatement("DELETE FROM PRENOTAZIONE WHERE ID_PRENOTAZIONE=?");
		try {
			stm.setInt(1, id);
			stm.executeUpdate();

		} finally {
			stm.close();
		}
	}
	
	public void inserisciPrenotazione(int id_ut, int id_spet, int id_pre, int id_p) throws SQLIntegrityConstraintViolationException, SQLException {
		//PreparedStatement stm1=con.prepareStatement("SELECT CURRENT_TIMESTAMP()");
		//ResultSet rs=stm1.executeQuery();
		//Timestamp data=rs.getTimestamp("current_timestamp()");
		PreparedStatement stm = con
				.prepareStatement("INSERT INTO PRENOTAZIONE (ID_UTENTE, ID_SPETTACOLO, ID_PREZZO, ID_POSTO, DATA_ORA_OPERAZIONE) VALUES (?,?,?,?,current_timestamp()) ");
		try {
			stm.setInt(1,id_ut);
			stm.setInt(2, id_spet);
			stm.setInt(3, id_pre);
			stm.setInt(4, id_p);
			//stm.setTimestamp(5, data);
			stm.executeUpdate();
		} finally {
			stm.close();
		}
	}
}
