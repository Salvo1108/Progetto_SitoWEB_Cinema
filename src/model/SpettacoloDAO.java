package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

public class SpettacoloDAO {
	private final transient Connection con;

	public SpettacoloDAO(DBManager manager) {
		this.con = manager.connection;
	}

	public SpettacoloDAO(Connection con) {
		this.con = con;
	}

	/**
	 * inserisce un nuovo spettacolo nel database.
	 * 
	 * @param sp spettacolo da inserire nel database
	 * @throws              java.sql.SQLIntegrityConstraintViolationException
	 * @throws SQLException
	 */
	public void inserisciSpettacolo(SpettacoloBean sp) throws SQLIntegrityConstraintViolationException, SQLException {
		// possiamo farci passare tutta una classe spettacolo

		PreparedStatement stm = con
				.prepareStatement("INSERT INTO SPETTACOLO (ID_FILM, ID_SALA, DATA_ORA) VALUES (?,?,?) ");
		try {
			stm.setInt(1, sp.getIdFilm());
			stm.setInt(2, sp.getIdSala());
			stm.setTimestamp(3, sp.getTimeStamp());
			stm.executeUpdate();
		} finally {
			stm.close();
		}
	}

	public void rimuoviSpettacolo(int id, Timestamp data) throws SQLException {
		PreparedStatement stm = con.prepareStatement("DELETE FROM SPETTACOLO WHERE ID_FILM=? AND DATA_ORA=? ");
		stm.setInt(1, id);
		stm.setTimestamp(2, data);
		stm.executeUpdate();
	}

	public boolean controlloSpettacolo(Timestamp data, int sala) throws SQLException {

		PreparedStatement stm = con
				.prepareStatement("SELECT *\n" + "FROM SPETTACOLO S\n" + "WHERE S.DATA_ORA=? AND ID_SALA=?");

		try {
			stm.setTimestamp(1, data);
			stm.setInt(2, sala);
			ResultSet rs = stm.executeQuery();
			try {
				if (rs.next()) {
					return true;
				}
			} finally {
				rs.close();
			}
		} finally {
			stm.close();
		}

		return false;
	}

	public ArrayList<Timestamp> getDataOra() throws SQLException {
		ArrayList<Timestamp> spettacoli = new ArrayList<>();
		PreparedStatement stm = con.prepareStatement("SELECT DISTINCT S.DATA_ORA\n" + "FROM SPETTACOLO S WHERE S.DATA_ORA>CURRENT_TIMESTAMP()\n");
		try {

			ResultSet rs = stm.executeQuery();
			TimeZone.setDefault(TimeZone.getTimeZone("GMT"));

			try {
				while (rs.next()) {
					Timestamp tmp = rs.getTimestamp("DATA_ORA");
					spettacoli.add(tmp);
				}
			} finally {
				rs.close();
			}
		} finally {
			stm.close();
		}
		return spettacoli;
	}

	public ArrayList<FilmBean> getFilmByDate(Timestamp gin) throws SQLException {
		TimeZone.setDefault(TimeZone.getTimeZone("GMT"));
		PreparedStatement stm = con.prepareStatement("select distinct * \n"
				+ "from spettacolo join film on film.ID_FILM=spettacolo.ID_FILM \n " + "where data_ora=?");

		ArrayList<FilmBean> num = new ArrayList<>();
		try {

			stm.setTimestamp(1, gin);
			ResultSet rs = stm.executeQuery();

			try {
				while (rs.next()) {
					FilmBean tmp = new FilmBean();

					tmp.setIdFilm(rs.getInt("ID_FILM"));
					tmp.setTitolo(rs.getString("TITOLO"));
					tmp.setIdGenere(rs.getInt("ID_GENERE"));

					tmp.setUrlTrailer(rs.getString("URL_TRAILER"));
					tmp.setDurata(rs.getInt("DURATA"));
					tmp.setTrama(rs.getString("TRAMA"));
					tmp.setUriLocandina(rs.getString("URI_LOCANDINA"));
					tmp.setisInSlider(rs.getBoolean("IS_IN_SLIDER"));
					tmp.setAnno(rs.getInt("ANNO"));
					tmp.setRegista(rs.getString("REGISTA"));
					tmp.setFotoSlide(rs.getString("FOTO_SL"));

					num.add(tmp);

				}
			} finally {
				rs.close();
			}
		} finally {
			stm.close();
		}

		return num;
	}
	
	public SpettacoloBean getSpettacoloByID(int ID) throws SQLException {

		PreparedStatement stm = con.prepareStatement(
				"select ID_SPETTACOLO,ID_FILM,ID_SALA,DATA_ORA\n" + "from spettacolo\n" + "where id_spettacolo=?");

		stm.setInt(1, ID);

		SpettacoloBean spet = new SpettacoloBean();
		ResultSet rs = stm.executeQuery();

		rs.next();
			
			spet.setIdSpettacolo(rs.getInt("ID_SPETTACOLO"));
			spet.setIdFilm(rs.getInt("ID_FILM"));
			spet.setDataOra(rs.getTimestamp("DATA_ORA"));
			spet.setIdSala(rs.getInt("ID_SALA"));

			return spet;
	}
		
}
