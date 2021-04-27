
package model;

public class UtenteRuoloBean {
	private UtenteBean utente;
	private RuoloBean ruolo;

	public UtenteRuoloBean() {
		utente = null;
		ruolo = null;
	}

	public UtenteBean getUtente() {
		return utente;
	}

	public void setUtente(UtenteBean utente) {
		this.utente = utente;
	}

	public RuoloBean getRuolo() {
		return ruolo;
	}

	public void setRuolo(RuoloBean ruolo) {
		this.ruolo = ruolo;
	}
}
