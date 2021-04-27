package model;

public class SalaBean {
	private int idSala;
	private String nome;
	private String descrizione;

	public SalaBean() {
		idSala = 0;
		nome = null;
		descrizione = null;
	}

	public int getIdSala() {
		return idSala;
	}

	public void setIdSala(int idSala) {
		this.idSala = idSala;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
}
