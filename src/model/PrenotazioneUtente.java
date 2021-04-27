package model;

public class PrenotazioneUtente {
	private String film;
	private String posto;
	private int sala;
	private int prezzo;
	
	public PrenotazioneUtente () {
		film=null;
		posto=null;
		sala=0;
		prezzo=0;
	}

	public String getFilm() {
		return film;
	}

	public void setFilm(String film) {
		this.film = film;
	}

	public String getPosto() {
		return posto;
	}

	public void setPosto(String posto) {
		this.posto = posto;
	}

	public int getSala() {
		return sala;
	}

	public void setSala(int sala) {
		this.sala = sala;
	}

	public int getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(int prezzo) {
		this.prezzo = prezzo;
	}

}
