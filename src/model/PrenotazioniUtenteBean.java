package model;

import java.sql.Timestamp;

public class PrenotazioniUtenteBean {

	private FilmBean film;
	private Timestamp dataOraSpettacolo;
	private Timestamp dataOraOperazione;
	private String nomeSala;
	private double tot; // totale soldi spesi per la prenotazione
	private int numBiglietti; // totale biglietti acquistati per la prenotazione

	public PrenotazioniUtenteBean() {
		film = null;
		dataOraOperazione = null;
		dataOraSpettacolo = null;
		nomeSala = null;
		tot = 0;
		numBiglietti = 0;
	}

	public FilmBean getFilm() {
		return film;
	}

	public void setFilm(FilmBean film) {
		this.film = film;
	}

	public Timestamp getDataOraSpettacolo() {
		return dataOraSpettacolo;
	}

	public void setDataOraSpettacolo(Timestamp dataOraSpettacolo) {
		this.dataOraSpettacolo = dataOraSpettacolo;
	}

	public Timestamp getDataOraOperazione() {
		return dataOraOperazione;
	}

	public void setDataOraOperazione(Timestamp dataOraOperazione) {
		this.dataOraOperazione = dataOraOperazione;
	}

	public String getNomeSala() {
		return nomeSala;
	}

	public void setNomeSala(String nomeSala) {
		this.nomeSala = nomeSala;
	}

	public double getTot() {
		return tot;
	}

	public void setTot(double tot) {
		this.tot = tot;
	}

	public int getNumBiglietti() {
		return numBiglietti;
	}

	public void setNumBiglietti(int numBiglietti) {
		this.numBiglietti = numBiglietti;
	}

}
