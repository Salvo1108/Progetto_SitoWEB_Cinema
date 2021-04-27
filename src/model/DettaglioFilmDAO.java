package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DettaglioFilmDAO {
	private final transient Connection con;

	public DettaglioFilmDAO(Connection con) {
		this.con = con;
	}

	public FilmBean getFilmConID(int ID) throws SQLException {
		PreparedStatement stm = con.prepareStatement(
				"select ID_FILM,ID_GENERE,TITOLO,DURATA,TRAMA,URL_TRAILER,URI_LOCANDINA,IS_IN_SLIDER,ANNO,REGISTA,FOTO_SL\r\n"
						+ "from Film\r\n" + "where id_film = ?");
		stm.setInt(1, ID);

		ResultSet rs = stm.executeQuery();
		FilmBean tmpFilm = new FilmBean();
		if (rs.next()) {

			tmpFilm.setIdFilm(rs.getInt("ID_FILM"));
			tmpFilm.setIdGenere(rs.getInt("ID_GENERE"));
			tmpFilm.setDurata(rs.getInt("DURATA"));
			tmpFilm.setTitolo(rs.getString("TITOLO"));
			tmpFilm.setTrama(rs.getString("TRAMA"));
			tmpFilm.setisInSlider(rs.getBoolean("IS_IN_SLIDER"));
			tmpFilm.setUriLocandina(rs.getString("URI_LOCANDINA"));
			tmpFilm.setUrlTrailer(rs.getString("URL_TRAILER"));
			tmpFilm.setAnno(rs.getInt("ANNO"));
			tmpFilm.setRegista(rs.getString("REGISTA"));

		}

		return tmpFilm;

	}

}
