package model;

import java.sql.Timestamp;

public class SpettacoloSalaOrario {
	private SpettacoloBean spettacolo;
	private FilmBean film;
	private SalaBean sala;
	private GenereBean genere;

	public FilmBean getFilm() {
		return film;
	}

	public void setFilm(FilmBean film) {
		this.film = film;
	}

	public SalaBean getSala() {
		return sala;
	}

	public void setSala(SalaBean sala) {
		this.sala = sala;
	}

	public Timestamp getDataOra() {
		return spettacolo.getTimeStamp();
	}

	public void setDataOra(Timestamp dataOra) {
		if (spettacolo == null) {
			spettacolo = new SpettacoloBean();
		}
		spettacolo.setDataOra(dataOra);
	}

	public GenereBean getGenere() {
		return genere;
	}

	public void setGenere(GenereBean genere) {
		this.genere = genere;
	}

	public SpettacoloBean getSpettacolo() {
		return spettacolo;
	}

	public void setSpettacolo(SpettacoloBean spettacolo) {
		this.spettacolo = spettacolo;
	}
}