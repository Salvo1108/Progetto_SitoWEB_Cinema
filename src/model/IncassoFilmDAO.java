package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class IncassoFilmDAO {
	private final transient Connection con;

	public IncassoFilmDAO(DBManager manager) {
		this.con = manager.connection;
	}

	public IncassoFilmDAO(Connection con) {
		this.con = con;
	}

	/*
	 * return un oggetto che permette di accedere al film e al suo incasso.
	 */
	public ArrayList<IncassoFilmBean> getFilmIncasso() throws SQLException {
		ArrayList<IncassoFilmBean> res = new ArrayList<>();
		PreparedStatement stm;
		stm = con.prepareStatement(
				"SELECT DISTINCT F.ID_FILM, F.ID_GENERE, F.TITOLO, F.DURATA, F.TRAMA,F.IS_IN_SLIDER, F.URL_TRAILER, F.URI_LOCANDINA, F.ANNO, F.REGISTA, SUM(PR.PREZZO) AS TOT, TMP.NUM\n"
						+ "FROM FILM F JOIN SPETTACOLO S ON F.ID_FILM = S.ID_FILM JOIN PRENOTAZIONE P ON P.ID_SPETTACOLO = S.ID_SPETTACOLO JOIN PREZZO PR ON PR.ID_PREZZO = P.ID_PREZZO JOIN (SELECT ID_FILM, COUNT(ID_SPETTACOLO) AS NUM FROM SPETTACOLO WHERE DATA_ORA < CURRENT_TIMESTAMP GROUP BY ID_FILM) AS TMP ON S.ID_FILM = TMP.ID_FILM\n"
						+ "WHERE S.DATA_ORA < CURRENT_TIMESTAMP\n" + "GROUP BY  F.TITOLO");

		try {
			ResultSet rs = stm.executeQuery();
			try {
				while (rs.next()) {
					IncassoFilmBean tmp = new IncassoFilmBean();
					FilmBean film = new FilmBean();

					film.setIdFilm(rs.getInt("ID_FILM"));
					film.setIdGenere(rs.getInt("ID_GENERE"));
					film.setTitolo(rs.getString("TITOLO"));
					film.setDurata(rs.getInt("DURATA"));
					film.setTrama(rs.getString("TRAMA"));
					film.setUrlTrailer(rs.getString("URL_TRAILER"));
					film.setisInSlider(rs.getBoolean("IS_IN_SLIDER"));
					film.setUriLocandina(rs.getString("URI_LOCANDINA"));
					film.setAnno(rs.getInt("ANNO"));
					film.setRegista(rs.getString("REGISTA"));

					tmp.setFilm(film);
					double incasso = rs.getDouble("TOT");
					int num = rs.getInt("NUM");
					double incassoMedio = incasso / num;

					tmp.setIncasso(incasso);
					tmp.setNumSpett(num);
					tmp.setIncassoMedio(incassoMedio);

					res.add(tmp);
				}
			} finally {
				rs.close();
			}
		} finally {
			stm.close();
		}
		return res;
	}
}
