package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class SpettacoloSalaOrarioDAO {
	private final transient Connection con;

	public SpettacoloSalaOrarioDAO(DBManager manager) {
		this.con = manager.connection;
	}

	public SpettacoloSalaOrarioDAO(Connection con) {
		this.con = con;
	}

	public ArrayList<AdminPrenotazioneUtentiBean> getPrenotazioni() throws SQLException {
		ArrayList<AdminPrenotazioneUtentiBean> res = new ArrayList<>();
		PreparedStatement stm = con.prepareStatement("SELECT *\n"
				+ "FROM FILM F JOIN SPETTACOLO SP ON F.ID_FILM = SP.ID_FILM JOIN GENERE G ON F.ID_GENERE = G.ID_GENERE JOIN SALA S ON S.ID_SALA=SP.ID_SALA JOIN PRENOTAZIONE P ON P.ID_SPETTACOLO = SP.ID_SPETTACOLO JOIN PREZZO PREZ ON PREZ.ID_PREZZO = P.ID_PREZZO JOIN POSTO POST ON POST.ID_POSTO = P.ID_POSTO JOIN UTENTE UT ON UT.ID_UTENTE = P.ID_UTENTE JOIN RUOLO R ON R.ID_RUOLO = UT.ID_RUOLO \n"
				+ "ORDER BY F.ID_FILM");
		ResultSet rs = stm.executeQuery();
		try {
			while (rs.next()) {
				AdminPrenotazioneUtentiBean tmp = new AdminPrenotazioneUtentiBean();
				FilmBean tmpFilm = new FilmBean();
				tmpFilm.setDurata(rs.getInt("DURATA"));
				tmpFilm.setIdFilm(rs.getInt("ID_FILM"));
				tmpFilm.setIdGenere(rs.getInt("ID_GENERE"));
				tmpFilm.setisInSlider(rs.getBoolean("IS_IN_SLIDER"));
				tmpFilm.setTitolo(rs.getString("TITOLO"));
				tmpFilm.setTrama(rs.getString("TRAMA"));
				tmpFilm.setUriLocandina(rs.getString("URI_LOCANDINA"));
				tmpFilm.setUrlTrailer(rs.getString("URL_TRAILER"));
				tmpFilm.setRegista(rs.getString("REGISTA"));
				tmpFilm.setAnno(rs.getInt("ANNO"));

				GenereBean tmpGenere = new GenereBean();
				tmpGenere.setIdGenere(rs.getInt("ID_GENERE"));
				tmpGenere.setDescrizione(rs.getString("DESCRIZIONE"));

				SpettacoloBean spett = new SpettacoloBean();
				spett.setIdSpettacolo(rs.getInt("ID_SPETTACOLO"));
				spett.setDataOra(rs.getTimestamp("DATA_ORA"));

				SalaBean tmpSala = new SalaBean();
				tmpSala.setDescrizione(rs.getString("DESCRIZIONE"));
				tmpSala.setIdSala(rs.getInt("ID_SALA"));
				tmpSala.setNome(rs.getString("NOME"));

				UtenteBean tmpUtente = new UtenteBean();
				tmpUtente.setIdUtente(rs.getInt("ID_UTENTE"));
				tmpUtente.setIdRuolo(rs.getInt("ID_RUOLO"));
				tmpUtente.setEmail(rs.getString("EMAIL"));

				PrenotazioneBean tmpPrenotazione = new PrenotazioneBean();
				tmpPrenotazione.setIdPrenotazione(rs.getInt("ID_PRENOTAZIONE"));
				tmpPrenotazione.setIdSpettacolo(rs.getInt("ID_SPETTACOLO"));
				tmpPrenotazione.setIdUtente(rs.getInt("ID_UTENTE"));
				tmpPrenotazione.setIdPrezzo(rs.getInt("ID_PREZZO"));
				tmpPrenotazione.setIdPosto(rs.getInt("ID_POSTO"));
				tmpPrenotazione.setDataOraOperazione(rs.getTimestamp("DATA_ORA_OPERAZIONE"));

				PrezzoBean tmpPrezzo = new PrezzoBean();
				tmpPrezzo.setIdPrezzo(rs.getInt("ID_PREZZO"));
				tmpPrezzo.setPrezzo(rs.getDouble("PREZZO"));
				tmpPrezzo.setTipo(rs.getString("TIPO"));

				RuoloBean tmpRuolo = new RuoloBean();
				tmpRuolo.setIdRuolo(rs.getInt("ID_RUOLO"));
				tmpRuolo.setRuolo(rs.getString("RUOLO"));

				PostoBean tmpPosto = new PostoBean();
				tmpPosto.setIdPosto(rs.getInt("ID_POSTO"));
				tmpPosto.setIdSala(rs.getInt("ID_SALA"));
				tmpPosto.setRiga(rs.getString("RIGA").charAt(0));
				tmpPosto.setColonna(rs.getInt("COLONNA"));

				tmp.setFilm(tmpFilm);
				tmp.setSala(tmpSala);
				tmp.setGenere(tmpGenere);
				tmp.setSpettacolo(spett);
				tmp.setUtente(tmpUtente);
				tmp.setPrenotazione(tmpPrenotazione);
				tmp.setPrezzo(tmpPrezzo);
				tmp.setRuolo(tmpRuolo);
				tmp.setPosto(tmpPosto);

				res.add(tmp);
			}
		} finally {
			rs.close();
		}
		return res;
	}

	public List<SpettacoloBean> getSpettacolo(int ID) throws SQLException {

		PreparedStatement stm = con.prepareStatement(
				"select ID_SPETTACOLO,ID_FILM,ID_SALA,DATA_ORA\n" + "from spettacolo\n" + "where id_film=?");

		stm.setInt(1, ID);

		List<SpettacoloBean> list = new ArrayList<SpettacoloBean>();
		ResultSet rs = stm.executeQuery();

		while (rs.next()) {

			SpettacoloBean tmpSpettacoli = new SpettacoloBean();
			tmpSpettacoli.setIdFilm(rs.getInt("ID_FILM"));
			tmpSpettacoli.setDataOra(rs.getTimestamp("DATA_ORA"));
			tmpSpettacoli.setIdSala(rs.getInt("ID_SALA"));

			list.add(tmpSpettacoli);
		}

		return list;

	}

	public SpettacoloSalaOrario getSpettacolo1(int ID, Timestamp data) throws SQLException {

		PreparedStatement stm = con.prepareStatement("select distinct *\n" + "from spettacolo s, film f, sala sa\n"
				+ "where s.id_film=? and s.data_ora=? and s.id_film=f.id_film and sa.id_sala=s.id_sala ;");

		stm.setInt(1, ID);
		stm.setTimestamp(2, data);
		SpettacoloSalaOrario tmp = null;
		ResultSet rs = stm.executeQuery();

		if (rs.next()) {

			tmp = new SpettacoloSalaOrario();
			FilmBean tmpFilm = new FilmBean();

			tmpFilm.setDurata(rs.getInt("DURATA"));
			tmpFilm.setIdFilm(rs.getInt("ID_FILM"));
			tmpFilm.setIdGenere(rs.getInt("ID_GENERE"));
			tmpFilm.setisInSlider(rs.getBoolean("IS_IN_SLIDER"));
			tmpFilm.setTitolo(rs.getString("TITOLO"));
			tmpFilm.setTrama(rs.getString("TRAMA"));
			tmpFilm.setUriLocandina(rs.getString("URI_LOCANDINA"));
			tmpFilm.setUrlTrailer(rs.getString("URL_TRAILER"));
			tmpFilm.setRegista(rs.getString("REGISTA"));
			tmpFilm.setAnno(rs.getInt("ANNO"));

			SpettacoloBean spett = new SpettacoloBean();
			spett.setIdSpettacolo(rs.getInt("ID_SPETTACOLO"));
			spett.setDataOra(rs.getTimestamp("DATA_ORA"));
			spett.setIdFilm(rs.getInt("ID_FILM"));
			spett.setIdSala(rs.getInt("ID_SALA"));

			SalaBean tmpSala = new SalaBean();
			tmpSala.setDescrizione(rs.getString("DESCRIZIONE"));
			tmpSala.setIdSala(rs.getInt("ID_SALA"));
			tmpSala.setNome(rs.getString("NOME"));

			tmp.setFilm(tmpFilm);
			tmp.setSala(tmpSala);
			tmp.setSpettacolo(spett);
		}

		return tmp;

	}

}
