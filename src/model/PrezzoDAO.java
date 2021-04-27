package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PrezzoDAO {
	private final transient Connection con;

	public PrezzoDAO(DBManager manager) {
		this.con = manager.connection;
	}

	public PrezzoDAO(Connection con) {
		this.con = con;
	}

	/*
	 * ritorna una lista di tutti i tipi di prezzi
	 * 
	 * @return lista di tutti i prezzi possibili
	 */
	public ArrayList<PrezzoBean> getAllPrezzi() throws SQLException {
		PreparedStatement stm = con.prepareStatement("SELECT ID_PREZZO, TIPO, PREZZO FROM PREZZO");
		ArrayList<PrezzoBean> prezzi = new ArrayList<>();
		try {
			ResultSet rs = stm.executeQuery();
			try {
				while (rs.next()) {
					PrezzoBean tmp = new PrezzoBean();
					tmp.setIdPrezzo(rs.getInt("ID_PREZZO"));
					tmp.setPrezzo(rs.getDouble("PREZZO"));
					tmp.setTipo(rs.getString("TIPO"));
					prezzi.add(tmp);
				}
			} finally {
				rs.close();
			}
		} finally {
			stm.close();
		}
		return prezzi;
	}
	public PrezzoBean getprezzoBeanByPrezzo(int prezzo) throws SQLException {
		PreparedStatement stm = con.prepareStatement("SELECT * FROM PREZZO \n" + 
				"WHERE PREZZO.PREZZO=?;");
		
		
		stm.setInt(1,prezzo);
		PrezzoBean tmp = new PrezzoBean();
		try {
			ResultSet rs = stm.executeQuery();
			try {
				while (rs.next()) {
					tmp.setIdPrezzo(rs.getInt("ID_PREZZO"));
					tmp.setPrezzo(rs.getDouble("PREZZO"));
					tmp.setTipo(rs.getString("TIPO"));
				}
			} finally {
				rs.close();
			}
		} finally {
			stm.close();
		}
		return tmp;
	}
	
	

}
