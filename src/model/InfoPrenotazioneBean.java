package model;

public class InfoPrenotazioneBean {
	private FilmBean film;
	private SpettacoloBean spettacolo;
	private SalaBean sala;

	public InfoPrenotazioneBean() {
		film = null;
		spettacolo = null;
		sala = null;
	}

	public FilmBean getFilm() {
		return film;
	}

	public void setFilm(FilmBean film) {
		this.film = film;
	}

	public SpettacoloBean getSpettacolo() {
		return spettacolo;
	}

	public void setSpettacolo(SpettacoloBean spettacolo) {
		this.spettacolo = spettacolo;
	}

	public SalaBean getSala() {
		return sala;
	}

	public void setSala(SalaBean sala) {
		this.sala = sala;
	}
}
