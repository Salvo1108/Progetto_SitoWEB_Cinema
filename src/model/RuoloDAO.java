package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RuoloDAO {

	private final transient Connection con;

	public RuoloDAO(Connection con) {
		this.con = con;
	}

	public int getRuolo(String email, String password) throws SQLException {

		int id = 0;
		PreparedStatement stm = con.prepareStatement("SELECT ID_RUOLO FROM UTENTE WHERE EMAIL=? AND PASSWORD=?");
		stm.setString(1, email);
		stm.setString(2, password);
		ResultSet rs = stm.executeQuery();

		if (rs.next()) {
			if (rs.getInt("ID_RUOLO") == 1) {

				return 1;
			}

			if (rs.getInt("ID_RUOLO") == 2) {

				return 2;
			}
		} else
			return 0;
		rs.close();
		stm.close();

		return id;
	}
}
