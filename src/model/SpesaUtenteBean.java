package model;

public class SpesaUtenteBean {
	private UtenteBean ut;
	private int numPrenotazioni;
	private double spesaTot;

	public SpesaUtenteBean() {
		ut = null;
		numPrenotazioni = 0;
		spesaTot = 0;
	}

	public UtenteBean getUt() {
		return ut;
	}

	public void setUt(UtenteBean ut) {
		this.ut = ut;
	}

	public int getNumPrenotazioni() {
		return numPrenotazioni;
	}

	public void setNumPrenotazioni(int numPrenotazioni) {
		this.numPrenotazioni = numPrenotazioni;
	}

	public double getSpesaTot() {
		return spesaTot;
	}

	public void setSpesaTot(double spesaTot) {
		this.spesaTot = spesaTot;
	}
}
