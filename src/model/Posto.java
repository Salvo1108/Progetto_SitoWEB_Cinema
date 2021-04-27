package model;

public class Posto {

	public Posto() {
		p = null;
		stato = false;
	}

	public PostoBean getP() {
		return p;
	}

	public void setP(PostoBean p) {
		this.p = p;
	}

	public boolean getStato() {
		return stato;
	}

	public void setStato(boolean stato) {
		this.stato = stato;
	}

	private PostoBean p;
	private boolean stato; // false è libero, true è occupato

	@Override
	public String toString() {
		return "Posto [p=" + p + ", stato=" + stato + "]";
	}

}
