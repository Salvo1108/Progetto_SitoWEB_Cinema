package model;

public class GenereBean {
	private int idGenere;
	private String descrizione; // max size: 50

	public int getIdGenere() {
		return idGenere;
	}

	public void setIdGenere(int idGenere) {
		this.idGenere = idGenere;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
}
