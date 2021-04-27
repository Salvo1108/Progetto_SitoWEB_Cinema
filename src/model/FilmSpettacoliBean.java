package model;

import java.util.ArrayList;

public class FilmSpettacoliBean {
	private FilmBean film;
	private ArrayList<SpettacoloBean> spettacoli;
	private GenereBean genere;

	public FilmSpettacoliBean() {
		film = null;
		spettacoli = null;
		genere = null;
	}

	public FilmBean getFilm() {
		return film;
	}

	public void setFilm(FilmBean film) {
		this.film = film;
	}

	public ArrayList<SpettacoloBean> getSpettacoli() {
		return spettacoli;
	}

	public String getSpettacolo() {
		String spet = null;
		for (SpettacoloBean spettacoloBean : spettacoli) {
			spet = spettacoloBean.getData() + " - " + spettacoloBean.getOra() + "\n";
		}
		return spet;
	}

	public void setSpettacoli(ArrayList<SpettacoloBean> spettacoli) {
		this.spettacoli = spettacoli;
	}

	public GenereBean getGenere() {
		return genere;
	}

	public void setGenere(GenereBean genere) {
		this.genere = genere;
	}
}
