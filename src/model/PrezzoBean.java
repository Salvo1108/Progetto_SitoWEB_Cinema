package model;

public class PrezzoBean {
	private int idPrezzo;
	private String tipo;
	private double prezzo;

	public PrezzoBean() {
		idPrezzo = 0;
		tipo = null;
		prezzo = 0;
	}

	public int getIdPrezzo() {
		return idPrezzo;
	}

	public void setIdPrezzo(int idPrezzo) {
		this.idPrezzo = idPrezzo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
}
