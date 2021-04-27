package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

public class FilmDAO {

	private final transient Connection con;

	public FilmDAO(Connection con) {
		this.con = con;
	}

	public FilmDAO(DBManager manager) {
		this.con = manager.connection;
	}

	public List<FilmBean> getFilms() throws SQLException {
		PreparedStatement stm = con.prepareStatement(
				"SELECT ID_FILM,TITOLO, ID_GENERE, URL_TRAILER,DURATA,TRAMA, URI_LOCANDINA, IS_IN_SLIDER, ANNO, REGISTA, FOTO_SL FROM FILM");
		List<FilmBean> film = new ArrayList<>();
		try {
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

					film.add(tmp);
				}
			} finally {
				rs.close();
			}
		} finally {
			stm.close();
		}
		return film;
	}

	public void inserisciFilm(FilmBean fm) throws SQLIntegrityConstraintViolationException, SQLException {
		PreparedStatement stm = con.prepareStatement(
				"INSERT INTO FILM (TITOLO, ID_GENERE, URL_TRAILER, DURATA, TRAMA, URI_LOCANDINA, IS_IN_SLIDER, ANNO, REGISTA) VALUES (?,?,?,?,?,?,?,?,?)");
		try {
			stm.setString(1, fm.getTitolo());
			stm.setInt(2, fm.getIdGenere());
			stm.setString(3, fm.getUrlTrailer());
			stm.setInt(4, fm.getDurata());
			stm.setString(5, fm.getTrama());
			stm.setString(6, fm.getUriLocandina());
			stm.setBoolean(7, fm.isInSlider());
			stm.setInt(8, fm.getAnno());
			stm.setString(9, fm.getRegista());

			stm.executeUpdate();
		} finally {
			stm.close();
		}
	}

	public ArrayList<FilmBean> getFilmsSlider() throws SQLException {
		ArrayList<FilmBean> film = new ArrayList<>();
		PreparedStatement stm = con.prepareStatement(
				"SELECT DISTINCT ID_FILM, TITOLO, ID_GENERE,URL_TRAILER, DURATA, TRAMA,URI_LOCANDINA,IS_IN_SLIDER, ANNO, REGISTA, FOTO_SL "
						+ "FROM FILM WHERE IS_IN_SLIDER=TRUE ");

		try {
			ResultSet rs = stm.executeQuery();
			try {

				while (rs.next()) {
					FilmBean tmp = new FilmBean();
					tmp.setIdFilm(rs.getInt("ID_FILM"));
					tmp.setTitolo(rs.getString("TITOLO"));
					tmp.setIdGenere(rs.getInt("ID_GENERE"));
					tmp.setUrlTrailer(rs.getString("URL_TRAILER"));
					tmp.setDurata(rs.getInt("DURATA"));
					tmp.setUriLocandina(rs.getString("URI_LOCANDINA"));
					tmp.setTrama(rs.getString("TRAMA"));
					tmp.setisInSlider(rs.getBoolean("IS_IN_SLIDER"));
					tmp.setRegista(rs.getString("REGISTA"));
					tmp.setAnno(rs.getInt("ANNO"));
					tmp.setFotoSlide(rs.getString("FOTO_SL"));

					film.add(tmp);
				}
			} finally {
				rs.close();
			}
		} finally {
			stm.close();
		}
		return film;
	}

	public int getIdFilm(String titolo) throws SQLException {
		int id = 0;
		PreparedStatement stm = con.prepareStatement("SELECT  ID_FILM " + "FROM FILM WHERE TITOLO=? ");
		stm.setString(1, titolo);

		ResultSet rs = stm.executeQuery();
		if (rs.next()) {
			id = rs.getInt("ID_FILM");
		}

		return id;

	}

	public ArrayList<String> getTitoli() throws SQLException {
		ArrayList<String> titoli = new ArrayList<>();
		PreparedStatement stm = con.prepareStatement("SELECT  TITOLO " + "FROM FILM ");

		try {
			ResultSet rs = stm.executeQuery();
			try {

				while (rs.next()) {
					titoli.add(rs.getString("TITOLO"));
				}
			} finally {
				rs.close();
			}
		} finally {
			stm.close();
		}
		return titoli;
	}

	public void rimuoviFilm(int id) throws SQLException {
		PreparedStatement stm = con.prepareStatement("DELETE FROM FILM WHERE ID_FILM=? ");
		stm.setInt(1, id);
		stm.executeUpdate();
	}
	
	public String getTitleFilm(int id_spettacolo) throws SQLException {
		int idfilm=0;
		PreparedStatement stm = con.prepareStatement("SELECT ID_FILM " + "FROM spettacolo WHERE id_spettacolo=? ");
		stm.setInt(1, id_spettacolo);
		ResultSet rs = stm.executeQuery();
		if (rs.next()) {
			idfilm = rs.getInt("ID_FILM");
		}
		
		String titolo=null;
		PreparedStatement stm1 = con.prepareStatement("SELECT titolo " + "FROM film WHERE id_film=? ");
		stm1.setInt(1, idfilm);
		ResultSet rs1 = stm1.executeQuery();
		if (rs1.next()) {
			titolo = rs1.getString("titolo");
		}
		return titolo;

	}
	public String getTitleFilmById(int idfilm) throws SQLException {
		String titolo=null;
		PreparedStatement stm1 = con.prepareStatement("SELECT titolo " + "FROM film WHERE id_film=? ");
		stm1.setInt(1, idfilm);
		ResultSet rs = stm1.executeQuery();
		if (rs.next()) {
			titolo = rs.getString("titolo");
		}
		return titolo;

	}

}
