package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PostoDAO {
	private final transient Connection con;

	public PostoDAO(DBManager manager) {
		this.con = manager.connection;
	}

	public PostoDAO(Connection con) {
		this.con = con;
	}

	/*
	 * restituisce tutti i posti liberi per un determinato spettacolo. spetta
	 * spettacolo di cui si vogliono ottenere i posti disponibili return lista di
	 * posti disponibili (toglie i rotti)
	 */
	public ArrayList<Posto> getPostiLiberi(SpettacoloBean spetta) throws SQLException {
		ArrayList<Posto> posti = new ArrayList<>();
		PreparedStatement stm = con.prepareStatement("SELECT distinct P.ID_POSTO, P.ID_SALA, P.RIGA, P.COLONNA\n"
				+ "FROM POSTO P\n" + "WHERE P.ID_SALA = ? AND P.ID_POSTO NOT IN(\n"
				+ "SELECT PR.ID_POSTO FROM PRENOTAZIONE PR WHERE PR.ID_SPETTACOLO = ?) order by riga");
		try {
			stm.setInt(1, spetta.getIdSala());
			stm.setInt(2, spetta.getIdSpettacolo());
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Posto posto = new Posto();
				PostoBean tmp = new PostoBean();
				tmp.setIdPosto(rs.getInt("ID_POSTO"));
				tmp.setIdSala(rs.getInt("ID_SALA"));
				tmp.setRiga(rs.getString("RIGA").charAt(0));
				tmp.setColonna(rs.getInt("COLONNA"));
				posto.setP(tmp);
				posto.setStato(false);
				posti.add(posto);
			}
		} finally {
			stm.close();
		}

		return posti;
	}

	public ArrayList<Posto> getPostiPrenotati(SpettacoloBean spetta) throws SQLException {

		ArrayList<Posto> posti = new ArrayList<>();
		PreparedStatement stm = con.prepareStatement("SELECT P.ID_POSTO, P.ID_SALA, P.RIGA, P.COLONNA\n"
				+ "FROM POSTO P\n" + "WHERE P.ID_SALA = ? AND P.ID_POSTO IN(\n"
				+ "SELECT PR.ID_POSTO FROM PRENOTAZIONE PR WHERE PR.ID_SPETTACOLO = ?) order by riga");
		try {
			stm.setInt(1, spetta.getIdSala());
			stm.setInt(2, spetta.getIdSpettacolo());
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Posto posto = new Posto();
				PostoBean tmp = new PostoBean();
				tmp.setIdPosto(rs.getInt("ID_POSTO"));
				tmp.setIdSala(rs.getInt("ID_SALA"));
				tmp.setRiga(rs.getString("RIGA").charAt(0));
				tmp.setColonna(rs.getInt("COLONNA"));
				posto.setP(tmp);
				posto.setStato(true);
				posti.add(posto);
			}
		} finally {
			stm.close();
		}
		return posti;

	}

	public Posto getPosto(String riga, String colonna, int id_sala) throws SQLException {

		Posto posto=new Posto();
		PreparedStatement stm = con.prepareStatement("SELECT *\n" + "				FROM posto \n"
				+ "                WHERE posto.colonna= ? and posto.riga=? and posto.id_sala=?");
		try {
			stm.setString(1, colonna);
			stm.setString(2, riga);
			stm.setInt(3, id_sala);
			ResultSet rs = stm.executeQuery();
			if (rs.next()) {
				PostoBean p=new PostoBean();
				p.setColonna(rs.getInt("COLONNA"));
				p.setRiga(rs.getString("RIGA").charAt(0));
				p.setIdSala(rs.getInt("ID_SALA"));
				p.setIdPosto(rs.getInt("id_posto"));
				posto.setP(p);
				posto.setStato(false);
			}

		} finally {
			stm.close();
		}
		return posto;
	}

public int getIDPosto(String riga,String colonna,int id_sala) throws SQLException {
		
		int idposto = 0;
		PreparedStatement stm = con.prepareStatement("SELECT distinct ID_POSTO\n" + 
				"				FROM posto \n" + 
				"                WHERE posto.colonna= ? and posto.riga=? and posto.id_sala=?");
		try {
			stm.setString(1, colonna);
			stm.setString(2, riga);
			stm.setInt(3, id_sala);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				
				idposto = rs.getInt("ID_POSTO");
			}
			
		}finally {
			stm.close();
		}
		return idposto;
	}

}
