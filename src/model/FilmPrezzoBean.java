package model;

public class FilmPrezzoBean {
	private FilmBean film;
	private PrezzoBean prezzo;

	public FilmPrezzoBean() {
		film = null;
		prezzo = null;
	}

	public FilmBean getFilm() {
		return film;
	}

	public void setFilm(FilmBean film) {
		this.film = film;
	}

	public PrezzoBean getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(PrezzoBean prezzo) {
		this.prezzo = prezzo;
	}

}
