package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class UtenteDAO {
	private final transient Connection con;

	public UtenteDAO(DBManager manager) {
		this.con = manager.connection;
	}

	public UtenteDAO(Connection con) {
		this.con = con;
	}

	public UtenteBean getUtente(String email, String password) throws SQLException {
		UtenteBean utente = new UtenteBean();
		PreparedStatement stm = con.prepareStatement("SELECT * FROM UTENTE WHERE EMAIL = ? AND PASSWORD=?");
		try {
			stm.setString(1, email);
			stm.setString(2, password);
			ResultSet rs = stm.executeQuery();
			if (rs.next()) {
				utente.setEmail(rs.getString("EMAIL"));
				utente.setPassword(rs.getString("PASSWORD"));
				utente.setIdRuolo(rs.getInt("ID_RUOLO"));
				utente.setIdUtente(rs.getInt("ID_UTENTE"));
			}
		} finally {
			stm.close();
		}
		return utente;
	}

	/*
	 * inserisce un nuovo utente nel database. ut utente da aggiungere
	 */
	public void aggiungiUtente(UtenteBean ut) throws SQLIntegrityConstraintViolationException, SQLException {
		PreparedStatement stm = con.prepareStatement("INSERT INTO UTENTE (ID_RUOLO, EMAIL, PASSWORD) VALUES (?,?,?)");
		try {
			stm.setInt(1, ut.getIdRuolo());
			stm.setString(2, ut.getEmail());
			stm.setString(3, ut.getPassword());
			stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public UtenteBean getUtente(int idUtente) throws SQLIntegrityConstraintViolationException, SQLException {
		UtenteBean utente = new UtenteBean();

		PreparedStatement stm = con.prepareStatement("SELECT * FROM UTENTE WHERE ID_UTENTE=?");

		try {
			stm.setInt(1, idUtente);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				utente.setIdUtente(idUtente);
				utente.setEmail(rs.getString("EMAIL"));
				utente.setPassword(rs.getString("PASSWORD"));
				utente.setIdRuolo(rs.getInt("ID_RUOLO"));
			}
		} finally {
			stm.close();
		}

		return utente;
	}

	public boolean verificaUtente(String email) throws SQLException {
		PreparedStatement stm = con.prepareStatement("SELECT * FROM UTENTE WHERE EMAIL=?");

		try {
			stm.setString(1, email);
			ResultSet rs = stm.executeQuery();
			if (rs.next())
				return true;

		} finally {
			stm.close();
		}
		return false;
	}

	public void cambiaPassword(String email, String password) throws SQLException {
		PreparedStatement stm = con.prepareStatement("UPDATE UTENTE SET PASSWORD = ? WHERE EMAIL = ?");
		try {
			stm.setString(1, password);
			stm.setString(2, email);
			stm.executeUpdate();
		} finally {
			stm.close();
		}
	}
}
