package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StoricoPrenotazioneAreaUtenteDAO {

	private final transient Connection con;

	public StoricoPrenotazioneAreaUtenteDAO(DBManager manager) {
		this.con = manager.connection;
	}

	public StoricoPrenotazioneAreaUtenteDAO(Connection con) {
		this.con = con;
	}

	public ArrayList<AdminPrenotazioneUtentiBean> getPrenotazioni(int ID) throws SQLException {

		PreparedStatement stm = con.prepareStatement("select *\r\n"
				+ "from prenotazione, (select s.id_spettacolo, film.id_film, id_genere, titolo, durata, trama, url_trailer, uri_locandina, is_in_slider, anno, regista, foto_sl\r\n"
				+ "						from spettacolo s join film on s.id_film=film.id_film\r\n"
				+ "                        ) as film, (select * from prezzo) as prezzo\r\n"
				+ "where id_utente=? and  prenotazione.id_spettacolo=film.id_spettacolo and prenotazione.id_prezzo=prezzo.id_prezzo\r\n"
				+ "");

		stm.setInt(1, ID);

		ArrayList<AdminPrenotazioneUtentiBean> list = new ArrayList<AdminPrenotazioneUtentiBean>();
		ResultSet rs = stm.executeQuery();

		while (rs.next()) {
			AdminPrenotazioneUtentiBean tmp = new AdminPrenotazioneUtentiBean();
			PrenotazioneBean pren = new PrenotazioneBean();
			FilmBean film = new FilmBean();
			PrezzoBean pr = new PrezzoBean();

			film.setDurata(rs.getInt("DURATA"));
			film.setIdFilm(rs.getInt("ID_FILM"));
			film.setIdGenere(rs.getInt("ID_GENERE"));
			film.setisInSlider(rs.getBoolean("IS_IN_SLIDER"));
			film.setTitolo(rs.getString("TITOLO"));
			film.setTrama(rs.getString("TRAMA"));
			film.setUriLocandina(rs.getString("URI_LOCANDINA"));
			film.setUrlTrailer(rs.getString("URL_TRAILER"));
			film.setRegista(rs.getString("REGISTA"));
			film.setAnno(rs.getInt("ANNO"));

			pren.setDataOraOperazione(rs.getTimestamp("DATA_ORA_OPERAZIONE"));
			pren.setIdUtente(rs.getInt("ID_UTENTE"));
			pren.setIdSpettacolo(rs.getInt("ID_SPETTACOLO"));
			pren.setIdPrenotazione(rs.getInt("ID_PRENOTAZIONE"));
			pren.setIdSpettacolo(rs.getInt("ID_PREZZO"));
			pren.setIdPrenotazione(rs.getInt("ID_POSTO"));

			pr.setIdPrezzo(rs.getInt("ID_PREZZO"));
			pr.setPrezzo(rs.getDouble("PREZZO"));
			pr.setTipo(rs.getString("TIPO"));

			tmp.setFilm(film);
			tmp.setPrenotazione(pren);
			tmp.setPrezzo(pr);

			list.add(tmp);

		}

		return list;

	}

}
