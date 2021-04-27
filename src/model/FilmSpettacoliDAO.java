package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FilmSpettacoliDAO {
	private final transient Connection con;

	public FilmSpettacoliDAO(DBManager manager) {
		this.con = manager.connection;
	}

	public FilmSpettacoliDAO(Connection con) {
		this.con = con;
	}


	public boolean getSpettacoliById(int id) throws SQLException {
		PreparedStatement stm = con.prepareStatement("SELECT *\n" + "FROM SPETTACOLO\n" + "WHERE ID_FILM=?\n");
		stm.setInt(1, id);
		ResultSet rs = stm.executeQuery();
		if (rs.next())
			return true;
		else
			return false;

	}
}
