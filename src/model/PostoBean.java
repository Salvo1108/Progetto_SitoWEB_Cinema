package model;

public class PostoBean {

	private int idPosto;
	private int idSala;
	private char riga;
	private int colonna;

	public PostoBean() {
		idPosto = 0;
		idSala = 0;
		riga = 0;
		colonna = 0;

	}

	public int getIdPosto() {
		return idPosto;
	}

	public void setIdPosto(int idPosto) {
		this.idPosto = idPosto;
	}

	public int getIdSala() {
		return idSala;
	}

	public void setIdSala(int idSala) {
		this.idSala = idSala;
	}

	public char getRiga() {
		return riga;
	}

	public void setRiga(char r) {
		this.riga = r;
	}

	public int getColonna() {
		return colonna;
	}

	public void setColonna(int colonna) {
		this.colonna = colonna;
	}

}
