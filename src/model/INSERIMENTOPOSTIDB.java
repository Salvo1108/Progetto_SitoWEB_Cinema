package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class INSERIMENTOPOSTIDB {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		DBManager man = new DBManager();
		inserisciPosti(man.getConn());

	}

	public static void inserisciPosti(Connection con) throws SQLException {
		PreparedStatement stm;
		// FILA A
		for (int j = 1; j <= 12; j++) {
			stm = con.prepareStatement("INSERT INTO POSTO (ID_SALA, RIGA, COLONNA)\n" + "VALUES(1,'A',?);\n");
			stm.setInt(1, j);
			stm.executeUpdate();
		}
		for (int j = 1; j <= 12; j++) {
			stm = con.prepareStatement("INSERT INTO POSTO (ID_SALA, RIGA, COLONNA)\n" + "VALUES(2,'A',?);\n");
			stm.setInt(1, j);
			stm.executeUpdate();
		}
		for (int j = 1; j <= 12; j++) {
			stm = con.prepareStatement("INSERT INTO POSTO (ID_SALA, RIGA, COLONNA)\n" + "VALUES(3,'A',?);\n");
			stm.setInt(1, j);
			stm.executeUpdate();
		}
		for (int j = 1; j <= 12; j++) {
			stm = con.prepareStatement("INSERT INTO POSTO (ID_SALA, RIGA, COLONNA)\n" + "VALUES(4,'A',?);\n");
			stm.setInt(1, j);
			stm.executeUpdate();
		}
		for (int j = 1; j <= 12; j++) {
			stm = con.prepareStatement("INSERT INTO POSTO (ID_SALA, RIGA, COLONNA)\n" + "VALUES(5,'A',?);\n");
			stm.setInt(1, j);
			stm.executeUpdate();
		}

		// FILA B
		for (int j = 1; j <= 12; j++) {
			stm = con.prepareStatement("INSERT INTO POSTO (ID_SALA, RIGA, COLONNA)\n" + "VALUES(1,'B',?);\n");
			stm.setInt(1, j);
			stm.executeUpdate();
		}
		for (int j = 1; j <= 12; j++) {
			stm = con.prepareStatement("INSERT INTO POSTO (ID_SALA, RIGA, COLONNA)\n" + "VALUES(2,'B',?);\n");
			stm.setInt(1, j);
			stm.executeUpdate();
		}
		for (int j = 1; j <= 12; j++) {
			stm = con.prepareStatement("INSERT INTO POSTO (ID_SALA, RIGA, COLONNA)\n" + "VALUES(3,'B',?);\n");
			stm.setInt(1, j);
			stm.executeUpdate();
		}
		for (int j = 1; j <= 12; j++) {
			stm = con.prepareStatement("INSERT INTO POSTO (ID_SALA, RIGA, COLONNA)\n" + "VALUES(4,'B',?);\n");
			stm.setInt(1, j);
			stm.executeUpdate();
		}
		for (int j = 1; j <= 12; j++) {
			stm = con.prepareStatement("INSERT INTO POSTO (ID_SALA, RIGA, COLONNA)\n" + "VALUES(5,'B',?);\n");
			stm.setInt(1, j);
			stm.executeUpdate();
		}

		// FILA C
		for (int j = 1; j <= 12; j++) {
			stm = con.prepareStatement("INSERT INTO POSTO (ID_SALA, RIGA, COLONNA)\n" + "VALUES(1,'C',?);\n");
			stm.setInt(1, j);
			stm.executeUpdate();
		}
		for (int j = 1; j <= 12; j++) {
			stm = con.prepareStatement("INSERT INTO POSTO (ID_SALA, RIGA, COLONNA)\n" + "VALUES(2,'C',?);\n");
			stm.setInt(1, j);
			stm.executeUpdate();
		}
		for (int j = 1; j <= 12; j++) {
			stm = con.prepareStatement("INSERT INTO POSTO (ID_SALA, RIGA, COLONNA)\n" + "VALUES(3,'C',?);\n");
			stm.setInt(1, j);
			stm.executeUpdate();
		}
		for (int j = 1; j <= 12; j++) {
			stm = con.prepareStatement("INSERT INTO POSTO (ID_SALA, RIGA, COLONNA)\n" + "VALUES(4,'C',?);\n");
			stm.setInt(1, j);
			stm.executeUpdate();
		}
		for (int j = 1; j <= 12; j++) {
			stm = con.prepareStatement("INSERT INTO POSTO (ID_SALA, RIGA, COLONNA)\n" + "VALUES(5,'C',?);\n");
			stm.setInt(1, j);
			stm.executeUpdate();
		}

		// FILA D
		for (int j = 1; j <= 12; j++) {
			stm = con.prepareStatement("INSERT INTO POSTO (ID_SALA, RIGA, COLONNA)\n" + "VALUES(1,'D',?);\n");
			stm.setInt(1, j);
			stm.executeUpdate();
		}
		for (int j = 1; j <= 12; j++) {
			stm = con.prepareStatement("INSERT INTO POSTO (ID_SALA, RIGA, COLONNA)\n" + "VALUES(2,'D',?);\n");
			stm.setInt(1, j);
			stm.executeUpdate();
		}
		for (int j = 1; j <= 12; j++) {
			stm = con.prepareStatement("INSERT INTO POSTO (ID_SALA, RIGA, COLONNA)\n" + "VALUES(3,'D',?);\n");
			stm.setInt(1, j);
			stm.executeUpdate();
		}
		for (int j = 1; j <= 12; j++) {
			stm = con.prepareStatement("INSERT INTO POSTO (ID_SALA, RIGA, COLONNA)\n" + "VALUES(4,'D',?);\n");
			stm.setInt(1, j);
			stm.executeUpdate();
		}
		for (int j = 1; j <= 12; j++) {
			stm = con.prepareStatement("INSERT INTO POSTO (ID_SALA, RIGA, COLONNA)\n" + "VALUES(5,'D',?);\n");
			stm.setInt(1, j);
			stm.executeUpdate();
		}

		// FILA E
		for (int j = 1; j <= 12; j++) {
			stm = con.prepareStatement("INSERT INTO POSTO (ID_SALA, RIGA, COLONNA)\n" + "VALUES(1,'E',?);\n");
			stm.setInt(1, j);
			stm.executeUpdate();
		}
		for (int j = 1; j <= 12; j++) {
			stm = con.prepareStatement("INSERT INTO POSTO (ID_SALA, RIGA, COLONNA)\n" + "VALUES(2,'E',?);\n");
			stm.setInt(1, j);
			stm.executeUpdate();
		}
		for (int j = 1; j <= 12; j++) {
			stm = con.prepareStatement("INSERT INTO POSTO (ID_SALA, RIGA, COLONNA)\n" + "VALUES(3,'E',?);\n");
			stm.setInt(1, j);
			stm.executeUpdate();
		}
		for (int j = 1; j <= 12; j++) {
			stm = con.prepareStatement("INSERT INTO POSTO (ID_SALA, RIGA, COLONNA)\n" + "VALUES(4,'E',?);\n");
			stm.setInt(1, j);
			stm.executeUpdate();
		}
		for (int j = 1; j <= 12; j++) {
			stm = con.prepareStatement("INSERT INTO POSTO (ID_SALA, RIGA, COLONNA)\n" + "VALUES(5,'E',?);\n");
			stm.setInt(1, j);
			stm.executeUpdate();
		}

		// FILA F
		for (int j = 1; j <= 12; j++) {
			stm = con.prepareStatement("INSERT INTO POSTO (ID_SALA, RIGA, COLONNA)\n" + "VALUES(1,'F',?);\n");
			stm.setInt(1, j);
			stm.executeUpdate();
		}
		for (int j = 1; j <= 12; j++) {
			stm = con.prepareStatement("INSERT INTO POSTO (ID_SALA, RIGA, COLONNA)\n" + "VALUES(2,'F',?);\n");
			stm.setInt(1, j);
			stm.executeUpdate();
		}
		for (int j = 1; j <= 12; j++) {
			stm = con.prepareStatement("INSERT INTO POSTO (ID_SALA, RIGA, COLONNA)\n" + "VALUES(3,'F',?);\n");
			stm.setInt(1, j);
			stm.executeUpdate();
		}
		for (int j = 1; j <= 12; j++) {
			stm = con.prepareStatement("INSERT INTO POSTO (ID_SALA, RIGA, COLONNA)\n" + "VALUES(4,'F',?);\n");
			stm.setInt(1, j);
			stm.executeUpdate();
		}
		for (int j = 1; j <= 12; j++) {
			stm = con.prepareStatement("INSERT INTO POSTO (ID_SALA, RIGA, COLONNA)\n" + "VALUES(5,'F',?);\n");
			stm.setInt(1, j);
			stm.executeUpdate();
		}

		// FILA G
		for (int j = 1; j <= 12; j++) {
			stm = con.prepareStatement("INSERT INTO POSTO (ID_SALA, RIGA, COLONNA)\n" + "VALUES(1,'G',?);\n");
			stm.setInt(1, j);
			stm.executeUpdate();
		}
		for (int j = 1; j <= 12; j++) {
			stm = con.prepareStatement("INSERT INTO POSTO (ID_SALA, RIGA, COLONNA)\n" + "VALUES(2,'G',?);\n");
			stm.setInt(1, j);
			stm.executeUpdate();
		}
		for (int j = 1; j <= 12; j++) {
			stm = con.prepareStatement("INSERT INTO POSTO (ID_SALA, RIGA, COLONNA)\n" + "VALUES(3,'G',?);\n");
			stm.setInt(1, j);
			stm.executeUpdate();
		}
		for (int j = 1; j <= 12; j++) {
			stm = con.prepareStatement("INSERT INTO POSTO (ID_SALA, RIGA, COLONNA)\n" + "VALUES(4,'G',?);\n");
			stm.setInt(1, j);
			stm.executeUpdate();
		}
		for (int j = 1; j <= 12; j++) {
			stm = con.prepareStatement("INSERT INTO POSTO (ID_SALA, RIGA, COLONNA)\n" + "VALUES(5,'G',?);\n");
			stm.setInt(1, j);
			stm.executeUpdate();
		}
		// FILA H
		for (int j = 1; j <= 12; j++) {
			stm = con.prepareStatement("INSERT INTO POSTO (ID_SALA, RIGA, COLONNA)\n" + "VALUES(1,'H',?);\n");
			stm.setInt(1, j);
			stm.executeUpdate();
		}
		for (int j = 1; j <= 12; j++) {
			stm = con.prepareStatement("INSERT INTO POSTO (ID_SALA, RIGA, COLONNA)\n" + "VALUES(2,'H',?);\n");
			stm.setInt(1, j);
			stm.executeUpdate();
		}
		for (int j = 1; j <= 12; j++) {
			stm = con.prepareStatement("INSERT INTO POSTO (ID_SALA, RIGA, COLONNA)\n" + "VALUES(3,'H',?);\n");
			stm.setInt(1, j);
			stm.executeUpdate();
		}
		for (int j = 1; j <= 12; j++) {
			stm = con.prepareStatement("INSERT INTO POSTO (ID_SALA, RIGA, COLONNA)\n" + "VALUES(4,'H',?);\n");
			stm.setInt(1, j);
			stm.executeUpdate();
		}
		for (int j = 1; j <= 12; j++) {
			stm = con.prepareStatement("INSERT INTO POSTO (ID_SALA, RIGA, COLONNA)\n" + "VALUES(5,'H',?);\n");
			stm.setInt(1, j);
			stm.executeUpdate();
		}

	}

}
