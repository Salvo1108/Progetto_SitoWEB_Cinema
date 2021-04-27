package model;

import java.sql.Timestamp;

public class PrenotazioneBean {
	private int idPrenotazione;
	private int idUtente;
	private int idSpettacolo;
	private int idPrezzo;
	private int idPosto;
	private Timestamp dataOraOperazione;

	public PrenotazioneBean() {
		idPrenotazione = 0;
		idUtente = 0;
		idSpettacolo = 0;
		idPrezzo = 0;
		idPosto = 0;
		dataOraOperazione = null;
	}

	public int getIdPrenotazione() {
		return idPrenotazione;
	}

	public void setIdPrenotazione(int idPrenotazione) {
		this.idPrenotazione = idPrenotazione;
	}

	public int getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(int idUtente) {
		this.idUtente = idUtente;
	}

	public int getIdSpettacolo() {
		return idSpettacolo;
	}

	public void setIdSpettacolo(int idSpettacolo) {
		this.idSpettacolo = idSpettacolo;
	}

	public int getIdPrezzo() {
		return idPrezzo;
	}

	public void setIdPrezzo(int idPrezzo) {
		this.idPrezzo = idPrezzo;
	}

	public int getIdPosto() {
		return idPosto;
	}

	public void setIdPosto(int idPosto) {
		this.idPosto = idPosto;
	}

	public Timestamp getDataOraOperazione() {
		return dataOraOperazione;
	}

	public void setDataOraOperazione(Timestamp dataOraOperazione) {
		this.dataOraOperazione = dataOraOperazione;
	}
}
