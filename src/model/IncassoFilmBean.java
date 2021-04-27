package model;

public class IncassoFilmBean {
	private FilmBean film;
	private double incasso;
	private int numSpett;
	private double incassoMedio;

	public IncassoFilmBean() {
		film = null;
		incasso = 0;
		numSpett = 0;
		incassoMedio = 0;
	}

	public FilmBean getFilm() {
		return film;
	}

	public void setFilm(FilmBean film) {
		this.film = film;
	}

	public double getIncasso() {
		return incasso;
	}

	public void setIncasso(double incasso) {
		this.incasso = incasso;
	}

	public int getNumSpett() {
		return numSpett;
	}

	public void setNumSpett(int numSpett) {
		this.numSpett = numSpett;
	}

	public double getIncassoMedio() {
		return incassoMedio;
	}

	public void setIncassoMedio(double incassoMedio) {
		this.incassoMedio = incassoMedio;
	}
}
